$(() => {
	get_all_rencana();
	$('#page_sorting2').hide();
});

function get_all_rencana() {
	$("#data_rows").html(
		`<tr> <td colspan="4" style="text-align:center"><i>Loading...</i> </td></td></tr>`
	);
	$.ajax({
		url: "/api/rencana/",
		type: "get",
		contentType: "application/json",
		success: function (result) {
			$("#data_rows").html("");
			if (result.length > 0) {
				for (let i = 0; i < result.length; i++) {
					$("#data_rows").append(

						`
												<tr>
												<td>
											<div class="row font-weight-bold">
												<div class="col-sm">${result[i].scheduleCode}</div>
												<div class="col-sm"><h5>${result[i].scheduleDate}, ${result[i].time}</h5></div>
												
												<div class="col-sm">
													<p class="">RO      :${result[i].ro.biodataId.fullName}</p>
													<p class="">TRO     : ${result[i].tro.biodataId.fullName}</p>
													<p class="">Location     : ${result[i].location}</p>
													<p class = "" id = "out-mode">Mode   : <p id="sent"></p> </p>
													<p class="">Jenis Jadwal  : ${result[i].scheduleTypeId.name}</p>
												</div>
												
												<div class="col-sm">
												 <h5 class="">
                          <a onclick="get_data_byid(${result[i].id},'edit')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="hapus(${result[i].id})"  class="mr-2" data-toggle="modal" data-target="" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                          <a onclick="get_data_byid(${result[i].id},'detail')"  class="mr-2" data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
                        </h5>
												</div>

											</div>
											</td>
                       </tr> 
											 `);
				}
			} else {
				$("#data_rows").html(
					`<tr> <td colspan="4" style="text-align:center"><i>Data tidak ditemukan...</i> </td></tr>`
				);
			}
		},
		error: function () {
			swal("", "Failed to fetch data", "error");
		}
	});
};

//set tanggal dari
$(function () {
	$("#input-search-dari").daterangepicker({
		autoUpdateInput: true,
		singleDatePicker: true,
		minYear: 1980,
		maxYear: parseInt(moment().format("YYYY"), 10),
		locale: {
			format: "YYYY-MM-DD"
		}
	});
});

//membatasi tanggal sampai
$("#input-search-dari").on("change", function () {
	var mindts = $("#input-search-dari").val();
	setmindate_kapan(mindts);
});

// set tanggal sampai
function setmindate_kapan(min) {
	$("#input-search-sampai").daterangepicker({
		autoUpdateInput: true,
		singleDatePicker: true,
		minDate: min,
		maxYear: parseInt(moment().format("YYYY"), 10),
		locale: {
			format: "YYYY-MM-DD"
		}
	});
}

// set tanggal rencana
$(function () {
	$("#get_tgl_rencana").daterangepicker({
		autoUpdateInput: true,
		singleDatePicker: true,
		minYear: parseInt(moment().format("YYYY"), 10),
		minDate: moment(),
		locale: {
			format: "YYYY-MM-DD"
		}
	});
});

// set tanggal rencana
$(function () {
	$("#get_sent_date").daterangepicker({
		autoUpdateInput: true,
		singleDatePicker: true,
		drops: "up",
		minYear: parseInt(moment().format("YYYY"), 10),
		minDate: moment(),
		locale: {
			format: "YYYY-MM-DD"
		}
	});
});

// set jam rencana
$(function () {
	$("#get_jam_rencana")
		.daterangepicker({
			timePicker: true,
			autoUpdateInput: true,
			singleDatePicker: true,
			timePicker24Hour: true,
			timePickerIncrement: 1,
			locale: {
				format: "HH:mm A"
			}
		})
		.on("show.daterangepicker", function (ev, picker) {
			picker.container.find(".calendar-table").hide();
		});
});

// menambah rencana
$("#add_rencana").click(function () {
	get_typeschedule();
	get_ro_isero_true();
	get_tro_isero_true();
	$(".modal-judul").text("Buat Rencana Jadwal ");
	$(".get_rencana").attr("disabled", false);
	$("#get_form_rencana")[0].reset();
	$("#get_id").val("");

	$("#action").val("add");
	$("#modal-rencana").modal("show");
});

//menghapus inputan
$("#btn-reset").on("click", function () {
	$("#input-search-dari, #input-search-sampai").val("");
});

// fungsi menccari data
$("#btn-search").on("click", function () {
	$("#data_rows").html("");
	var tgl_mulai = $('#input-search-dari').val();
	var tgl_sampai = $('#input-search-sampai').val();
	search_data(tgl_mulai, tgl_sampai);
});

// menambah rencana
$("#save_rencana").click(function () {
	cek_ro_tro();
	var action = $("#action").val();

	var data = {
		id: $("#get_id").val(),
		scheduleTypeId: {
			id: $("#get_schedule_type").val()
		},
		scheduleCode: $("#get_schedule_code").val(),
		scheduleDate: $("#get_tgl_rencana").val(),
		time: $("#get_jam_rencana").val(),
		ro: {
			id: $("#get_ro").val()
		},
		tro: {
			id: $("#get_tro").val()
		},
		location: $("#get_lokasi").val(),
		otherRoTro: $("#get_othertro").val(),
		notes: $("#get_notes").val(),
		isAutomaticMail: $("#cek_sent_date").val(),
		sentDate: $("#get_sent_date").val(),
	}

	if (action == "add") {
		type = "post";
	} else if (action == "edit") {
		type = "put";
	}

	$.ajax({
		url: "/api/rencana",
		type: type,
		contentType: "application/json",
		data: JSON.stringify(data),
		success: function (result) {
			$("#get_form_rencana")[0].reset();
			get_all_rencana();
			Toast.fire({
				icon: 'success',
				title: "Data berhasil di" + action + "."
			})
			$("#modal-rencana").modal("hide");
		},
		error: function () {
			Swal.fire("", "Failed to " + action + " data", "error");
		}
	});
});


// function hapus rencana /jadwal
function hapus(id) {
	var data = {
		id: $("#get_id").val()
	};
	Swal.fire({
		title: "Are you sure?",
		text: "You won't be able to revert this!",
		icon: "warning",
		showCancelButton: true,
		confirmButtonColor: "#3085d6",
		cancelButtonColor: "#d33",
		confirmButtonText: "Yes, delete it!"
	}).then(result => {
		if (result.value) {
			$.ajax({
				url: "/api/rencana/" + id,
				type: "delete",
				contentType: "application/json",
				data: JSON.stringify(data),
				success: function (result) {
					get_all_rencana();
					Toast.fire({
						icon: 'success',
						title: 'Data berhasil dihapus.'
					})
				},
				error: function () {
					Toast.fire({
						icon: 'error',
						title: 'Data gagal dihapus'
					})
				}
			});
		}
	});
};

// get data by id rencana 
function get_data_byid(id, action) {
	$("#action").val(action);

	$.ajax({
		url: "/api/rencana/" + id,
		type: "get",
		contentType: "application/json",
		success: function (rencana) {

			$("#get_form_rencana")[0].reset();

			get_ro_isero_true(rencana.ro.biodataId.id);
			get_tro_isero_true(rencana.tro.biodataId.id);
			get_typeschedule(rencana.scheduleTypeId.id);
			$("#get_id").val(rencana.id);
			$("#get_schedule_code").val(rencana.scheduleCode);
			$("#get_tgl_rencana").val(rencana.scheduleDate);
			$("#get_jam_rencana").val(rencana.time);
			$("#get_lokasi").val(rencana.location);
			$("#get_othertro").val(rencana.otherRoTro);
			$("#get_notes").val(rencana.notes);
			$("#get_sent_date").val(rencana.sentDate)
			$("#is_auto").val(result.isAutomaticMail)


			$(".modal-judul").text("");

			if (action == "detail") {
				$(".modal-judul").text("Detail Rencana");
				$(".get_rencana").attr("disabled", true);
			} else {
				$(".modal-judul").text("Ubah Rencana");
				$(".get_rencana").attr("disabled", false);
			}
			$("#modal-rencana").modal("show");
		},

		error: function () {
			swal.fire("", "Failed to fetch the data", "error");
		}
	});
};

// ajax schedule
function get_typeschedule(scheduleId) {
	$.ajax({
		url: "api/schedule/",
		type: "get",
		contentType: "application/json",
		success: function (sch) {
			var optValue = "";
			optValue += '<option value="">- Pilih Jenis Jadwal -</option>';
			for (var i = 0; i < sch.length; i++) {
				if (scheduleId == sch[i].id) {
					optValue += `<option value="${sch[i].id}" selected="selected">${sch[i].name}</option>`;
				} else {
					optValue += `<option value="${sch[i].id}">${sch[i].name}</option>`;
				}
			}
			$("#get_schedule_type").html(optValue);
		},
		error: function () {
			swal("", "Gagal Mengambil Data", "error");
		}
	});
}

//ajax get RO dengan is_ero = true
function get_ro_isero_true(roId) {
	$.ajax({
		url: "api/employee/erotrue",
		type: "get",
		contentType: "application/json",
		success: function (ro) {
			var optValue = "";
			optValue += '<option value="">- Pilih Nama RO -</option>';
			for (var i = 0; i < ro.length; i++) {
				if (roId == ro[i].id) {
					optValue += `<option value="${ro[i].biodataId.id}" selected="selected">${ro[i].biodataId.fullName}</option>`;
				} else {
					optValue += `<option value="${ro[i].biodataId.id}">${ro[i].biodataId.fullName}</option>`;
				}
			}
			$("#get_ro").html(optValue);
		},
		error: function () {
			swal("", "Gagal Mengambil Data", "error");
		}
	});
}

//ajax get TRO dengan is_ero = true
function get_tro_isero_true(troId) {
	$.ajax({
		url: "api/employee/erotrue",
		type: "get",
		contentType: "application/json",
		success: function (tro) {
			var optValue = "";
			optValue += '<option value="">- Pilih Nama TRO -</option>';
			for (var i = 0; i < tro.length; i++) {
				if (troId == tro[i].id) {
					optValue += `<option value="${tro[i].biodataId.id}" selected="selected">${tro[i].biodataId.fullName}</option>`;
				} else {
					optValue += `<option value="${tro[i].biodataId.id}">${tro[i].biodataId.fullName}</option>`;
				}
			}
			$("#get_tro").html(optValue);
		},
		error: function () {
			swal("", "Gagal Mengambil Data", "error");
		}
	});
}

// mengecek RO dan TRO tidak boleh memiliki jadwal yang sama
function cek_ro_tro() {
	var ro = $("#get_ro").val();
	var tro = $("#get_tro").val();
	if (ro === tro) {
		Swal.fire(
			"",
			"Ro dan TRO tidak boleh memiliki jadwal yang sama.",
			"info"
		);
	}
}

$('#cek_sent_date').click(function () {
	if ($('#cek_sent_date').is(':checked')) {
		$("#cek_sent_date").val("true")
		$("#get_sent_date").attr("disabled", false);
		$("#save_rencana").text("Simpan");
	} else {
		$("#save_rencana").text("Simpan & Kirim");
		$("#get_sent_date").val("");
		$("#get_sent_date").attr("disabled", true);
		$("#cek_sent_date").val("false")
	}
});

function ouput_mode() {
	var x = $("#cek_sent_date").val();
	if (x == true) {
		$("#sent").val("Otomatis");
	} else {
		$("#sent").val("Manual");
	}
};

const Toast = Swal.mixin({
	toast: true,
	position: 'bottom-end',
	showConfirmButton: false,
	timer: 3000,
	timerProgressBar: true,
	onOpen: (toast) => {
		toast.addEventListener('mouseenter', Swal.stopTimer)
		toast.addEventListener('mouseleave', Swal.resumeTimer)
	}
});


//Function search
function search_data(tgl_mulai, tgl_sampai) {
	$.ajax({
		url: "api/rencana/search?tgl_mulai=" + tgl_mulai + "&tgl_sampai=" + tgl_sampai,
		type: "get",
		contentType: "application/json",
		success: function (Data) {

			$("#data_rows").html("");
			if (Data.length > 0) {
				for (let i = 0; i < Data.length; i++) {
					$("#data_rows").append(

						`
												<tr>
												<td>
											<div class="row font-weight-bold">
												<div class="col-sm">${Data[i].scheduleCode}</div>
												<div class="col-sm"><h5>${Data[i].scheduleDate}, ${Data[i].time}</h5></div>
												
												<div class="col-sm">
													<p class="">RO      :${Data[i].ro.biodataId.fullName}</p>
													<p class="">TRO     : ${Data[i].tro.biodataId.fullName}</p>
													<p class="">Location     : ${Data[i].location}</p>
													<p class = "" id = "out-mode">Mode   : <p id="sent"></p> </p>
													<p class="">Jenis Jadwal  : ${Data[i].scheduleTypeId.name}</p>
												</div>
												
												<div class="col-sm">
												 <h5 class="">
                          <a onclick="get_data_byid(${Data[i].id},'edit')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="hapus(${Data[i].id})"  class="mr-2" data-toggle="modal" data-target="" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                          <a onclick="get_data_byid(${Data[i].id},'detail')"  class="mr-2" data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
                        </h5>
												</div>

											</div>
											</td>
                       </tr> 
											 `);
				}
			} else {
				$("#data_rows").html(
					`<tr> <td colspan="4" style="text-align:center"><i>Data tidak ditemukan...</i> </td></tr>`
				);
			}
		}
	});

}

$('#page_sorting1').on('click', function () {
	sorting_ascending();
	$('#page_sorting2').show();
	$('#page_sorting1').hide();
});

//sorting ascending data
function sorting_ascending() {
	$.ajax({
		url: "api/rencana/asc",
		type: 'get',
		contentType: 'application/json',
		success: function (asc) {
			$("#data_rows").html("");
			if (asc.length > 0) {
				for (let i = 0; i < asc.length; i++) {
					$("#data_rows").append(
						`
												<tr>
												<td>
											<div class="row font-weight-bold">
												<div class="col-sm">${asc[i].scheduleCode}</div>
												<div class="col-sm"><h5>${asc[i].scheduleDate}, ${asc[i].time}</h5></div>
												
												<div class="col-sm">
													<p class="">RO      :${asc[i].ro.biodataId.fullName}</p>
													<p class="">TRO     : ${asc[i].tro.biodataId.fullName}</p>
													<p class="">Location     : ${asc[i].location}</p>
													<p class = "" id = "out-mode">Mode   : <p id="sent"></p> </p>
													<p class="">Jenis Jadwal  : ${asc[i].scheduleTypeId.name}</p>
													</div>
													
												<div class="col-sm">
												<h5 class="">
                          <a onclick="get_data_byid(${asc[i].id},'edit')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
															<a onclick="hapus(${asc[i].id})"  class="mr-2" data-toggle="modal" data-target="" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                          <a onclick="get_data_byid(${asc[i].id},'detail')"  class="mr-2" data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
															</h5>
															</div>

											</div>
											</td>
                       </tr> 
											 `);
				}
			} else {
				$("#data_rows").html(
					`<tr> <td colspan="4" style="text-align:center"><i>Data tidak ditemukan...</i> </td></tr>`
				);
			}
		}
	});
};

$('#page_sorting2').on('click', function () {
	sorting_descending();
	$('#page_sorting1').show();
	$('#page_sorting2').hide();
});
// sorting descending data 
function sorting_descending() {
	$.ajax({
		url: "api/rencana/desc",
		type: 'get',
		contentType: 'application/json',
		success: function (asc) {
			$("#data_rows").html("");
			if (asc.length > 0) {
				for (let i = 0; i < asc.length; i++) {
					$("#data_rows").append(
						`
												<tr>
												<td>
											<div class="row font-weight-bold">
												<div class="col-sm">${asc[i].scheduleCode}</div>
												<div class="col-sm"><h5>${asc[i].scheduleDate}, ${asc[i].time}</h5></div>
												
												<div class="col-sm">
													<p class="">RO      :${asc[i].ro.biodataId.fullName}</p>
													<p class="">TRO     : ${asc[i].tro.biodataId.fullName}</p>
													<p class="">Location     : ${asc[i].location}</p>
													<p class = "" id = "out-mode">Mode   : <p id="sent"></p> </p>
													<p class="">Jenis Jadwal  : ${asc[i].scheduleTypeId.name}</p>
												</div>
												
												<div class="col-sm">
												 <h5 class="">
                          <a onclick="get_data_byid(${asc[i].id},'edit')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="hapus(${asc[i].id})"  class="mr-2" data-toggle="modal" data-target="" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                          <a onclick="get_data_byid(${asc[i].id},'detail')"  class="mr-2" data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
                        </h5>
												</div>

											</div>
											</td>
                       </tr> 
											 `);
				}
			} else {
				$("#data_rows").html(
					`<tr> <td colspan="4" style="text-align:center"><i>Data tidak ditemukan...</i> </td></tr>`
				);
			}
		}
	});
};