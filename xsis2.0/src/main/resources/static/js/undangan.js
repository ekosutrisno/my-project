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
                          <a onclick="get_data_byid(${result[i].id},'detail')"  class="mr-2" data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
                          <a onclick="get_data_byid(${result[i].id},'ubah')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="hapus(${result[i].id})"  class="mr-2" data-toggle="modal" data-target="" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                         
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

// set tanggal rencana
$(function () {
  $("#get_tgl_undangan").daterangepicker({
    autoUpdateInput: true,
    singleDatePicker: true,
    minYear: parseInt(moment().format("YYYY"), 10),
    minDate: moment(),
    locale: {
      format: "YYYY-MM-DD"
    }
  });
});


// set jam undangan
$(function () {
  $("#get_jam_undangan")
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
$("#add_undangan").click(function () {
  get_typeschedule();
  get_ro_isero_true();
  get_tro_isero_true();
  $(".modal-judul").text("Buat Jadwal Undangan");
  $(".get_undangan").attr("disabled", false);
  $("#get_form_undangan")[0].reset();
  $("#get_id").val("");

  $("#action").val("tambah");
  $("#modal-undangan").modal("show");
});

//menghapus inputan
$("#btn-reset").on("click", function () {
  $("#input-search-pelamar").val("");
});

// fungsi menccari data
$("#btn-search").on("click", function () {
  $("#data_rows").html("");
  var pelamar = $('#input-search-dari').val();

  if (pelamar == '') {
    swal.fire("Required", "pelamar tidak boleh kosong, silahkan isi kembali.", "info");
  } else {
    search_data(pelamar);
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
  paginate_data(0, 2, 'id', 'asc');
});

$('#data-show-20').on('click', function () {
  $("#prev").attr('disabled', true);
  $("#next").attr('disabled', false);
  paginate_data(0, 3, 'id', 'asc');
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