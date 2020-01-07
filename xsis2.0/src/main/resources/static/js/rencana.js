$(() => {
	get_all_rencana();
	$('#page_sorting2').hide();
	$("#get_sent_date").attr("disabled", true);
});

function get_all_rencana() {
	$("#data_rows").html(
		`<tr> <td colspan="4" style="text-align:center"><i>Loading...</i> </td></td></tr>`
	);
	$.ajax({
		url: "api/rencana/paging?size=10&page=0",
		type: "get",
		contentType: "application/json",
		success: function (result) {
			$("#total-data").text(result.totalElements);
			$("#total-size").text(result.totalPages);
			$("#total-page").text(result.size);
			$("#total-ke").text(result.pageable.pageNumber);
			$("#count-page").val(result.pageable.pageNumber);
			$("#count-first").val(result.first);
			$("#count-last").val(result.last);

			var result = result.content;
			$("#data_rows").html("");
			var x;
			if (result.length > 0) {
				for (let i = 0; i < result.length; i++) {
					var y = result[i].automaticMail;
					if (y == true) {
						x = "Otomatis";
					} else {
						x = "Manual";
					}
					$("#data_rows").append(

						`	<tr>
								<td>
											<div class="row font-weight-bold">
												<div class="col-sm">${result[i].scheduleCode}</div>
												<div class="col-sm"><h5>${result[i].scheduleDate}, ${result[i].time}</h5></div>
												
												<div class="col-sm">
													<p>RO      :${result[i].ro.biodataId.fullName} <br>
													TRO     : ${result[i].tro.biodataId.fullName}<br>
													Lokasi     : ${result[i].location} <br>
													Mode     : ${x} <br>
													Jenis Jadwal  : ${result[i].scheduleTypeId.name}</p>
												</div>
												
												<div class="col-sm">
												 <h5 class="">
                          <a onclick="get_data_byid(${result[i].id},'ubah')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
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
					`<tr> <td colspan="4">
					<div class="alert alert-primary text-center" role="alert">
						Data tidak ditemukan! <span><i class="fa fa-error"></i></span>
					</div> 
					</td></tr>`
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
	kode_rencana();
	$(".modal-judul").text("Buat Rencana Jadwal");
	$(".get_rencana").attr("disabled", false);
	$("#get_form_rencana")[0].reset();
	$("#get_id").val("");

	$("#action").val("tambah");
	$("#modal-rencana").modal("show");
});

//menghapus inputan
$("#btn-reset").on("click", function () {
	$("#input-search-dari, #input-search-sampai").val("");
	kirim_data()
});

// fungsi menccari data
$("#btn-search").on("click", function () {
	$("#data_rows").html("");
	var tgl_mulai = $('#input-search-dari').val();
	var tgl_sampai = $('#input-search-sampai').val();

	if (tgl_mulai == '' || tgl_sampai == '') {
		swal.fire("Required", "Tanggal pencarian tidak boleh kosong, silahkan isi kembali.", "info");
	} else {
		search_data(tgl_mulai, tgl_sampai);
	}

});

// meyimpan hasil tambah dan edit data rencana
$("#save_rencana").click(function () {
	var action = $("#action").val();
	var boolCek = $("#cek_sent_date").val();
	var boolValue;
	if (boolCek == 'true') {
		boolValue = true;
	} else {
		boolValue = false;
	}
	// mengecek RO dan TRO
	var ro = $("#get_ro").val();
	var tro = $("#get_tro").val();
	var sch = $("#get_schedule_type").val();
	var schDate = $("#get_tgl_rencana").val();
	var schTime = $("#get_jam_rencana").val();

	var data = {
		id: $("#get_id").val(),
		scheduleTypeId: {
			id: $("#get_schedule_type").val()
		},
		ro: {
			id: $("#get_ro").val()
		},
		tro: {
			id: $("#get_tro").val()
		},
		scheduleCode: $("#get_schedule_code").val(),
		scheduleDate: $("#get_tgl_rencana").val(),
		time: $("#get_jam_rencana").val(),
		location: $("#get_lokasi").val(),
		otherRoTro: $("#get_othertro").val(),
		notes: $("#get_notes").val(),
		isAuto: boolValue,
		sentDate: $("#get_sent_date").val(),
	}

	if (action == "tambah") {
		type = "post";
	} else if (action == "ubah") {
		type = "put";
	}

	var emp1 = $('#e1').is(':checked');
	var emp2 = $('#e2').is(':checked');
	var emp3 = $('#e3').is(':checked');

	if (schDate == '') {
		Swal.fire(
			"",
			"Anda belum memilih Tanggal perencannaan.",
			"question"
		);
	} else if (schTime == '') {
		Swal.fire(
			"",
			"Anda belum mengisi waktu perencanaan.",
			"question"
		);
	} else if (ro == '') {
		Swal.fire(
			"",
			"Anda belum memilih nama Recruitment Officer.",
			"info"
		);
	} else if (tro == '') {
		Swal.fire(
			"",
			"Anda belum memilih nama Technical Recruitment Officer.",
			"info"
		);
	} else if (ro == tro) {
		Swal.fire(
			"",
			"Ro dan TRO tidak boleh memiliki jadwal yang sama.",
			"info"
		);
	} else if (sch == '') {
		Swal.fire(
			"",
			"Anda belum memilih jenis Schedule.",
			"info"
		);
	} else if (!emp1 && !emp2 && !emp3) {
		Swal.fire(
			"",
			"Anda belum memilih pelamar.",
			"info"
		);
	} else if ($('#cek_sent_date').is(':checked') && $('#get_sent_date').val() == '') {
		Swal.fire("", "Mohon pilih tanggal pengiriman terlebih dahulu", "warning");
	} else {
		if ($('#cek_sent_date').is(':checked')) {
			$.ajax({
				url: "/api/rencana",
				type: type,
				contentType: "application/json",
				data: JSON.stringify(data),
				success: function (result) {
					get_all_rencana();
					Toast.fire({
						type: 'success',
						title: "Data berhasil di" + action + "."
					})
					$("#modal-rencana").modal("hide");
					$("#get_form_rencana")[0].reset();
				},
				error: function () {
					Swal.fire("", "Failed to " + action + " data", "error");
				}
			});
		} else {
			$.ajax({
				url: "/api/rencana",
				type: type,
				contentType: "application/json",
				data: JSON.stringify(data),
				success: function (result) {
					get_all_rencana();
					Toast.fire({
						type: 'success',
						title: "Data berhasil di" + action + "."
					})
					$("#modal-rencana").modal("hide");
					kirim_data();
					$("#get_form_rencana")[0].reset();
				},
				error: function () {
					Swal.fire("", "Failed to " + action + " data", "error");
				}
			});
		}


	}
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
	if (action == "detail") {
		$(".modal-judul").text("Detail Rencana");
		$(".get_rencana").attr("disabled", true);
		$(".x-hide").hide();
	} else {
		$(".modal-judul").text("Ubah Rencana");
		$(".get_rencana").attr("disabled", false);
		$(".x-hide").show();
	}

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
			$("#is_auto").val(rencana.isAutomaticMail)
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

$('#cek_sent_date').click(function () {
	if ($('#cek_sent_date').is(':checked')) {
		$("#cek_sent_date").val('true')
		$("#get_sent_date").attr("disabled", false);
		$("#save_rencana").text("Simpan");
	} else {
		$("#save_rencana").text("Simpan & Kirim");
		$("#get_sent_date").val("");
		$("#get_sent_date").attr("disabled", true);
		$("#cek_sent_date").val('false')
	}
});

const Toast = Swal.mixin({
	toast: true,
	position: 'bottom-end',
	showConfirmButton: false,
	timer: 3000,
	// timerProgressBar: true,
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
			var x;
			if (Data.length > 0) {
				for (let i = 0; i < Data.length; i++) {
					var y = Data[i].automaticMail;
					if (y == true) {
						x = "Otomatis";
					} else {
						x = "Manual";
					}
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
													<p class ="">Mode: ${x} </p>
													<p class="">Jenis Jadwal  : ${Data[i].scheduleTypeId.name}</p>
												</div>
												
												<div class="col-sm">
												 <h5 class="">
                          <a onclick="get_data_byid(${Data[i].id},'ubah')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
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
					`<tr> <td colspan="4">
					<div class="alert alert-primary text-center" role="alert">
						Data tidak ditemukan! <span><i class="fa fa-error"></i></span>
					</div> 
					</td></tr>`
				);
			}
		}
	});

}

$('#sort-data1').on('click', function () {
	var banyakdata = $("#show-info").text();
	paginate_data(0, banyakdata, 'id', 'asc');
	$('#page_sorting2').show();
	$('#page_sorting1').hide();
});

$('#sort-data2').on('click', function () {
	var banyakdata = $("#show-info").text();
	paginate_data(0, banyakdata, 'id', 'desc');
	$('#page_sorting1').show();
	$('#page_sorting2').hide();
});

// paginate data
function paginate_data(page, size, sortby, orderby) {
	$.ajax({
		url: "api/rencana/paging?page=" + page + "&size=" + size + "&sort=" + sortby + "," + orderby,
		type: 'get',
		contentType: 'application/json',
		success: function (pagination) {
			$("#total-data").text(pagination.totalElements);
			$("#total-page").text(pagination.size);
			$("#show-info").text(pagination.size);
			$("#total-size").text(pagination.totalPages);
			$("#total-ke").text(pagination.pageable.pageNumber);
			$("#count-page").val(pagination.pageable.pageNumber);
			$("#count-first").val(pagination.first);
			$("#count-last").val(pagination.last);

			var pagination = pagination.content;
			$("#data_rows").html("");
			var x;
			if (pagination.length > 0) {
				for (let i = 0; i < pagination.length; i++) {
					var y = pagination[i].automaticMail;
					if (y == true) {
						x = "Otomatis";
					} else {
						x = "Manual";
					}
					$("#data_rows").append(
						`
												<tr>
												<td>
											<div class="row font-weight-bold">
												<div class="col-sm">${pagination[i].scheduleCode}</div>
												<div class="col-sm"><h5>${pagination[i].scheduleDate}, ${pagination[i].time}</h5></div>
												
												<div class="col-sm">
													<p>RO      :${pagination[i].ro.biodataId.fullName} <br>
													TRO     : ${pagination[i].tro.biodataId.fullName}<br>
													Lokasi     : ${pagination[i].location} <br>
													Mode     : ${x} <br>
													Jenis Jadwal  : ${pagination[i].scheduleTypeId.name}</p>
												</div>
												
												<div class="col-sm">
												 <h5 class="">
                          <a onclick="get_data_byid(${pagination[i].id},'ubah')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="hapus(${pagination[i].id})"  class="mr-2" data-toggle="modal" data-target="" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                          <a onclick="get_data_byid(${pagination[i].id},'detail')"  class="mr-2" data-toggle="modal" data-target="#modal-rencana" href="#"
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
					`<tr> <td colspan="4">
					<div class="alert alert-primary text-center" role="alert">
						Data tidak ditemukan! <span><i class="fa fa-error"></i></span>
					</div> 
					</td></tr>`
				);
			}
		}
	});
};

// start menentukan banyak data perpage
$('#data-show-10').on('click', function () {
	$("#prev").attr('disabled', true);
	$("#next").attr('disabled', false);
	paginate_data(0, 10, 'id', 'asc');
});

$('#data-show-20').on('click', function () {
	$("#prev").attr('disabled', true);
	$("#next").attr('disabled', false);
	paginate_data(0, 20, 'id', 'asc');
});

$('#data-show-30').on('click', function () {
	$("#prev").attr('disabled', true);
	$("#next").attr('disabled', false);
	paginate_data(0, 30, 'id', 'asc');
});

$('#data-show-40').on('click', function () {
	$("#prev").attr('disabled', true);
	$("#next").attr('disabled', false);
	paginate_data(0, 40, 'id', 'asc');
});

$('#data-show-50').on('click', function () {
	$("#prev").attr('disabled', true);
	$("#next").attr('disabled', false);
	paginate_data(0, 50, 'id', 'asc');
});
//ending menentukan data perpage


//previous and next pabination
$('#prev').on('click', function () {
	var cekAwal = $("#count-first").val();
	var banyakdata = $("#show-info").text();
	var page = parseInt($('#count-page').val());

	if (cekAwal == "true") {
		$("#prev").attr("disabled", true);
		$("#next").attr("disabled", false);
	}

	if (page == 0) {
		page = 0;
	} else {
		page = page - 1;
	}
	paginate_data(page, banyakdata, 'id', 'asc');
	$("#count-first").val('');
	$("#count-last").val('false');
	$("#next").attr('disabled', false);
});

$('#next').on('click', function () {
	var cekAkhir = $("#count-last").val();
	var banyakdata = $("#show-info").text();
	var page = parseInt($('#count-page').val());

	if (cekAkhir == "true") {
		$("#next").attr("disabled", true);
		$("#prev").attr('disabled', false);
	}
	if (page >= 0) {
		page = page + 1;
		paginate_data(page, banyakdata, 'id', 'asc');
		$("#count-last").val('');
		$("#count-first").val('false');
		$("#prev").attr('disabled', false);
	}
});
// ending next dan previous function


//function mengirim ke email pelamar
function kirim_data() {
	var e1 = $('#e1').is(':checked');
	var e2 = $('#e2').is(':checked');
	var e3 = $('#e3').is(':checked');
	var plmr = '';

	if (e1 == true) {
		plmr = $('.e1').text();
	} else if (e2 == true) {
		plmr = $('.e2').text();
	} else if (e3 == true) {
		plmr = $('.e3').text();
	}

	var roff = $("#get_ro").val();
	var ro = '';
	if (roff == 1) {
		ro = 'Dwi Lisyanti, S.Pd';
	} else if (roff == 2) {
		ro = 'Alfia Husna, S.Si';
	} else if (roff == 3) {
		ro = 'Ario Bimo, S.Si'
	} else if (roff == 4) {
		ro = 'Muhammad Fathan'
	} else if (roff == 6) {
		ro = 'Eko Sutrisno, S.Pd'
	}

	var emp1 = $('#e1').is(':checked');
	var emp2 = $('#e2').is(':checked');
	var emp3 = $('#e3').is(':checked');
	var em = [];

	// penerima = 'debby.fudmasari@xsis.co.id';
	// penerima = 'imam.winata@xsis.co.id';
	// penerima = 'ariobimo74@gmail.com';


	if (emp1 == true && emp2 == false && emp3 == false) {
		em.push('ekosutrisno801@gmail.com');
		penerima = em.join();
	} else if (emp1 == false && emp2 == true && emp3 == false) {
		em.push('ekosutrisno801@yahoo.com');
		penerima = em.join();
	} else if (emp1 == false && emp2 == false && emp3 == true) {
		em.push('sutrisnoeko801@gmail.com');
		penerima = em.join();
	} else if (emp1 == true && emp2 == true && emp3 == false) {
		em.push('ekosutrisno801@gmail.com', 'ekosutrisno801@yahoo.com');
		penerima = em.join();
	} else if (emp1 == true && emp2 == false && emp3 == true) {
		em.push('ekosutrisno801@gmail.com', 'sutrisnoeko801@gmail.com');
		penerima = em.join();
	} else if (emp1 == false && emp2 == true && emp3 == true) {
		em.push('ekosutrisno801@yahoo.com', 'sutrisnoeko801@gmail.com');
		penerima = em.join();
	} else if (emp1 == true && emp2 == true && emp3 == true) {
		em.push('ekosutrisno801@gmail.com', 'ekosutrisno801@yahoo.com', 'sutrisnoeko801@gmail.com');
		penerima = em.join();
	}


	var judul = '';
	var namaro = $('#get_schedule_type').val();
	if (namaro == 1) {
		judul = 'Softskill';
	} else if (namaro == 2) {
		judul = 'Training';
	} else if (namaro == 3) {
		judul = 'Hiring';
	} else if (namaro == 4) {
		judul = 'Mini Project';
	} else if (namaro == 5) {
		judul = 'Filtering';
	} else if (namaro == 6) {
		judul = 'Kickoff Bootcamp';
	} else if (namaro == 7) {
		judul = 'Placement';
	} else if (namaro == 8) {
		judul = 'Interview';
	}

	// <strong>Nama<span> : </span>	 ` + nm + `</strong> <br>
	var nm = plmr;
	var tg = $("#get_tgl_rencana").val();
	var jm = $("#get_jam_rencana").val();
	var tm = $("#get_lokasi").val();
	var jd = judul;
	var ro = ro;
	var nt = $("#get_notes").val();

	var html = `
<!DOCTYPE html
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="format-detection" content="date=no" />
	<meta name="format-detection" content="address=no" />
	<meta name="format-detection" content="telephone=no" />
	<title>Email Template</title>


	<style type="text/css" media="screen">
		/* Linked Styles */
		body {
			padding: 0 !important;
			margin: 0 !important;
			display: block !important;
			min-width: 100% !important;
			width: 100% !important;
			background: #ffffff;
			-webkit-text-size-adjust: none
		}

		a {
			color: #4bb182;
			text-decoration: none
		}

		p {
			padding: 0 !important;
			margin: 0 !important
		}

		img {
			-ms-interpolation-mode: bicubic;
			/* Allow smoother rendering of resized image in Internet Explorer */
		}

		/* Mobile styles */
		@media only screen and (max-device-width: 480px),
		only screen and (max-width: 480px) {
			div[class='mobile-br-1'] {
				height: 1px !important;
			}

			div[class='mobile-br-1-b'] {
				height: 1px !important;
				background: #ffffff !important;
				display: block !important;
			}

			div[class='mobile-br-5'] {
				height: 5px !important;
			}

			div[class='mobile-br-10'] {
				height: 10px !important;
			}

			div[class='mobile-br-15'] {
				height: 15px !important;
			}

			div[class='mobile-br-20'] {
				height: 20px !important;
			}

			div[class='mobile-br-30'] {
				height: 30px !important;
			}

			th[class='m-td'],
			td[class='m-td'],
			div[class='hide-for-mobile'],
			span[class='hide-for-mobile'] {
				display: none !important;
				width: 0 !important;
				height: 0 !important;
				font-size: 0 !important;
				line-height: 0 !important;
				min-height: 0 !important;
			}

			span[class='mobile-block'] {
				display: block !important;
			}

			div[class='img-m-center'] {
				text-align: center !important;
			}

			div[class='h2-white-m-center'],
			div[class='text-white-m-center'],
			div[class='text-white-r-m-center'],
			div[class='h2-m-center'],
			div[class='text-m-center'],
			div[class='text-r-m-center'],
			td[class='text-top'],
			div[class='text-top'],
			div[class='h6-m-center'],
			div[class='text-m-center'],
			div[class='text-top-date'],
			div[class='text-white-top'],
			td[class='text-white-top'],
			td[class='text-white-top-r'],
			div[class='text-white-top-r'] {
				text-align: center !important;
			}

			div[class='fluid-img'] img,
			td[class='fluid-img'] img {
				width: 100% !important;
				max-width: 100% !important;
				height: auto !important;
			}

			table[class='mobile-shell'] {
				width: 100% !important;
				min-width: 100% !important;
			}

			table[class='center'] {
				margin: 0 auto;
			}

			th[class='column-rtl'],
			th[class='column-rtl2'],
			th[class='column-top'],
			th[class='column'] {
				float: left !important;
				width: 100% !important;
				display: block !important;
			}

			td[class='td'] {
				width: 100% !important;
				min-width: 100% !important;
			}

			td[class='content-spacing'] {
				width: 15px !important;
			}

			td[class='content-spacing2'] {
				width: 10px !important;
			}
		}
	</style>
</head>

<body class="body"
	style="padding:0 !important; margin:0 !important; display:block !important; min-width:100% !important; width:100% !important; background:#ffffff; -webkit-text-size-adjust:none">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
		<tr>
			<td align="center" valign="top">
				<!-- 3/ Header -->
				<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#4bb182">
					<tr>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
						<td align="center">
							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
								style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
								<tr>
									<td height="20" class="spacer"
										style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">&nbsp;</td>
								</tr>
							</table>

							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
								style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
								<tr>
									<td height="20" class="spacer"
										style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">&nbsp;</td>
								</tr>
							</table>
						</td>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
					</tr>
				</table>
				<!-- END 3/ Header -->
				<!-- Section 4 -->
				<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#e6e6e6">
					<tr>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
						<td align="center">
							<table width="650" border="0" cellspacing="0" cellpadding="0" class="mobile-shell">
								<tr>
									<td class="td"
										style="width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; Margin:0">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<!-- Head -->
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="50" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>

													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left"
																width="50"></td>
															<td>
																<div class="h3-grey-center"
																	style="color:#000000; font-family:Arial,sans-serif; font-size:26px; line-height:34px; text-align:center">
																	Jadwal ` + jd + `</div>
																<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
																	style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																	<tr>
																		<td height="22" class="spacer"
																			style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																			&nbsp;</td>
																	</tr>
																</table>

																<div class=""
																	style="color:#000000; font-family:Arial,sans-serif; font-size:14px; line-height:20px; text-align:left">
																	<p>Dear Kandidat, <br><br>
																	Berdasarkan berkas dan syarat lainnya yang telah anda kirimkan kepada kami, maka dari itu Kami
																	mengundangan Anda dalam agenda  ` + jd + ` yang akan dilaksanakan pada :<br>
																	<p><br>
																				<strong>Tanggal<span> : </span>	 ` + tg + `</strong><br>
																				<strong>Jam<span> : </span>	 ` + jm + `</strong><br>
																				<strong>Tempat<span> : </span>	 ` + tm + ` WIB</strong><br><br>
																				Atas perhatian dan kerjasamanya kami ucapkan terimaksaih.<br>
																				<strong>Notes<span> : </span>	</strong> ` + nt + `<br>
																	</p>
																</div>
																<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
																	style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																	<tr>
																		<td height="50" class="spacer"
																			style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																			&nbsp;</td>
																	</tr>
																</table>

															</td>
															<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left"
																width="50"></td>
														</tr>
													</table>
													<!-- END Head -->

													<!-- Articles -->
													<!-- row 1 -->
													<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
														<tr>
															<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left"
																width="10"></td>
															<td>
															</td>
														</tr>
													</table>

												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
					</tr>
				</table>
				<!-- END Section 4 -->

				<!-- Section 5 -->
				<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#4bb182">
					<tr>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
						<td align="center">
							<table width="650" border="0" cellspacing="0" cellpadding="0" class="mobile-shell">
								<tr>
									<td class="td"
										style="width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; Margin:0">
										<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
											style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
											<tr>
												<td height="50" class="spacer"
													style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">&nbsp;
												</td>
											</tr>
										</table>

										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="50">
												</td>
												<td>
													<div class="h3-white-center"
														style="color:#ffffff; font-family:Arial,sans-serif; font-size:26px; line-height:34px; text-align:center">
														What Our Clients Say About Us</div>
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="22" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>

													<div class="text-white-center"
														style="color:#ffffff; font-family:Arial,sans-serif; font-size:14px; line-height:20px; text-align:center">
														<em>"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt
															mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus"</em></div>
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="40" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="20" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>

													<div class="h6-white-center"
														style="color:#ffffff; font-family:Arial,sans-serif; font-size:16px; line-height:22px; text-align:center; font-weight:bold">
														` + ro + `</div>
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="6" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>

													<div class="text-white-center"
														style="color:#ffffff; font-family:Arial,sans-serif; font-size:14px; line-height:20px; text-align:center">
														Recruitmen Officer</div>
												</td>
												<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="50">
												</td>
											</tr>
										</table>
										<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
											style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
											<tr>
												<td height="50" class="spacer"
													style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">&nbsp;
												</td>
											</tr>
										</table>

									</td>
								</tr>
							</table>
						</td>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
					</tr>
				</table>
				<!-- END Section 5 -->


				<!-- Footer -->
				<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#f9f9f9">
					<tr>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
						<td align="center">
							<table width="650" border="0" cellspacing="0" cellpadding="0" class="mobile-shell">
								<tr>
									<td class="td"
										style="width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; Margin:0">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="30">
												</td>
												<td>
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<!-- Column -->
															<th class="column"
																style="font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; Margin:0"
																valign="bottom" width="266">
																<table width="100%" border="0" cellspacing="0" cellpadding="0">
																	<tr>
																		<td>
																			<div style="font-size:0pt; line-height:0pt;" class="mobile-br-20"></div>

																			<div class="text-m-center"
																				style="color:#777777; font-family:Arial,sans-serif; font-size:12px; line-height:20px; text-align:left">
																				<p>Copyright &copy; 2020 Xsis Academy</p>
																				</div>
																			<div style="font-size:0pt; line-height:0pt;" class="mobile-br-15"></div>

																		</td>
																	</tr>
																</table>
															</th>
															<!-- END Column -->
															<!-- Column -->
															<th class="column-top"
																style="font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; vertical-align:top; Margin:0">
																<table width="100%" border="0" cellspacing="0" cellpadding="0">
																	<tr>
																		<td>
																			<div class="text-r-m-center"
																				style="color:#777777; font-family:Arial,sans-serif; font-size:12px; line-height:24px; text-align:right">
																				<a href="#" target="_blank" class="link-grey2"
																					style="color:#666666; text-decoration:none"><span class="link-grey2"
																						style="color:#666666; text-decoration:none">Satrio Tower Lt. 25, Mega
																						Kuningan 9000</span></a>,Jakarta
																				<br />
																				<a href="www.xsis.academy" target="_blank" class="link-grey2-u"
																					style="color:#666666; text-decoration:underline"><span class="link-grey2-u"
																						style="color:#666666; text-decoration:underline">www.xsis.academy</span></a>
																				&nbsp; <a href="" target="_blank" class="link-grey2-u"
																					style="color:#666666; text-decoration:underline"><span class="link-grey2-u"
																						style="color:#666666; text-decoration:underline">xsisacademy@xsis.com</span></a>
																				<br />
																				Phone: <a href="tel:+1123456789" target="_blank" class="link-grey2"
																					style="color:#666666; text-decoration:none"><span class="link-grey2"
																						style="color:#666666; text-decoration:none">+1 (123) 456-789</span></a>
																			</div>
																		</td>
																	</tr>
																</table>
															</th>
															<!-- END Column -->
														</tr>
													</table>
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="40" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>

												</td>
												<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="30">
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#eeeeee">
								<tr>
									<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="30"></td>

								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!-- END Footer -->
			</td>
		</tr>
	</table>
</body>

</html>
`;


	var data = {
		penerima: penerima,
		judul: judul,
		konten: html
	}

	$.ajax({
		url: '/sendemail',
		type: 'post',
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function () {
			Swal.fire("Sukses", "Email berhasil dikirim ke " + penerima, "success");
		},
		error: function () {
			Swal.fire("Gagal", "Email gagal dikirim ke " + penerima, "error");
		}
	})
};



// function generating code 
function kode_rencana() {
	var kode = 'JDW';
	$.ajax({
		url: "/api/rencana/desc",
		type: 'get',
		contentType: "application/json",
		success: function (result) {
			var data = result[0];
			var code = data.scheduleCode;


			if (code == '' || null) {
				code = kode + '0001';
			}

			code = code.substring(3, code.length)
			code = parseInt(code);

			var cek = String(code).length;
			var tambahan = '';
			if (cek == 1) {
				tamabahan = '000'
			} else if (cek == 2) {
				tambahan = '00'
			} else if (cek == 3) {
				tambahan = '0'
			}

			code = kode + tambahan + (code + 1);
			$("#get_schedule_code").val(code)
		},
	});

}