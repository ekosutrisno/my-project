$(() => {
	get_all_rencana();
});

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
	$.ajax({
		url: "api/rencana/",
		type: "get",
		contentType: "application/json",
		success: function (data) {
			for (var i = 0; i < data.length; i++) {}
		}
	});
});

// menambah rencana
$("#save_rencana").click(function () {
	cek_ro_tro();

	// $("#modal-rencana").modal("show");
});

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
//mdngubah nilai is_automatic_sent menjaadi true / false
$("#isAutoEmail").on("click", function () {});

//menenable inputan date sent
function enable_sendate(cek) {
	cek != cek;
	if (cek) {
		$("#get_sent_date").attr("disabled", false);
	} else {
		$("#get_sent_date").val("");
		$("#get_sent_date").attr("disabled", true);
	}
}

//  $(function() {
//     $("#input-search").on("keyup", function() {
//        var rex = new RegExp($(this).val(), "i");
//        $(".blok-item").hide();
//        $(".blok-item")
//           .filter(function() {
//              return rex.test($(this).text());
//           })
//           .show();
//     });
//  });


function get_all_rencana() {
	var number = 1;
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
                          <td> ${number}</td>
                          <td> ${result[i].scheduleCode}</td>
                          <td> ${result[i].scheduleDate}</td>
                          <td> ${result[i].time}</td>
                          <td> ${result[i].ro}</td>
                          <td> ${result[i].tro}</td>
                          <td> ${result[i].location}</td>
                          <td> ${result[i].isAutomaticMail}</td>
                          <td> ${result[i].scheduleTypeId.name}</td>

                        <td>

                        <h5 class="">
                          <a onclick="get_data_byid( ${result[i].id},'edit')"  class="mr-2 " data-toggle="modal" data-target="#addModal" href="#"
                              id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="hapus(${result[i].id})"  class="mr-2" data-toggle="modal" data-target="#addModal" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                          <a onclick="get_data_byid(${result[i].id},'detail')"  class="mr-2" data-toggle="modal" data-target="#addModal" href="#"
                              id="showAddData"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
                        </h5>
                        
                        </td>
                       </tr> `
					);
					number++;
				}
			} else {
				$("#data_rows").html(
					`<tr> <td colspan="4" style="text-align:center"><i>Loading...</i> </td></tr>`
				);
			}
		},
		error: function () {
			swal("", "Failed to fetch data", "error");
		}
	});
};