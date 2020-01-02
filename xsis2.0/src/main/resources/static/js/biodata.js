$(() => {
   get_all_data();
   get_marriage_year();

});

$('#get_marital_status').change(function () {
   var x = $('#get_marital_status').val()
   if (x == 1) {
      $('.year_marriage').attr('disabled', true);
   } else {
      $('.year_marriage').attr('disabled', false);
   }
})

function get_religion(relId) {
   $.ajax({
      url: "../api/religion",
      type: "get",
      contentType: "application/json",
      success: function (rel) {
         var optValue = "";
         optValue += '<option value="">- Pilih Agama -</option>';
         for (var i = 0; i < rel.length; i++) {
            if (relId == rel[i].id) {
               optValue += `<option value="${rel[i].id}" selected="selected">${rel[i].name}</option>`;
            } else {
               optValue += `<option value="${rel[i].id}">${rel[i].name}</option>`;
            }
         }
         $("#get_religion").html(optValue);
      },
      error: function () {
         swal("", "Gagal Mengambil Data", "error");
      }
   });
};

function get_marital(marId) {
   $.ajax({
      url: "../api/marital",
      type: "get",
      contentType: "application/json",
      success: function (mar) {
         var optValue = "";
         optValue += '<option value="">- Pilih Status -</option>';
         for (var i = 0; i < mar.length; i++) {
            if (marId == mar[i].id) {
               optValue += `<option value="${mar[i].id}" selected="selected">${mar[i].name}</option>`;
            } else {
               optValue += `<option value="${mar[i].id}">${mar[i].name}</option>`;
            }
         }
         $("#get_marital_status").html(optValue);
      },
      error: function () {
         swal("", "Gagal Mengambil Data", "error");
      }
   });
};

function get_identitas(identId) {
   $.ajax({
      url: "../api/identitas",
      type: "get",
      contentType: "application/json",
      success: function (ident) {
         var optValue = "";
         optValue += '<option value="">- Pilih Identitas -</option>';
         for (var i = 0; i < ident.length; i++) {
            if (identId == ident[i].id) {
               optValue += `<option value="${ident[i].id}" selected="selected">${ident[i].name}</option>`;
            } else {
               optValue += `<option value="${ident[i].id}">${ident[i].name}</option>`;
            }
         }
         $("#get_type_identity").html(optValue);
      },
      error: function () {
         swal("", "Gagal Mengambil Data", "error");
      }
   });
};

function get_marriage_year() {
   var current_year = new Date();
   var year = current_year.getFullYear();
   var value_year = "";
   value_year += '<option value="">- Pilih Tahun Nikah -</option>';
   var i = 1990;
   while (i <= year) {
      value_year += `<option value="` + i + `">` + i + `</option>`;
      i++;
   }
   $("#get_marriage_year").html(value_year);
};

function get_all_data() {
   var number = 1;
   $("#data_rows").html(
      `<tr> <td colspan="4" style="text-align:center"><i>Loading...</i> </td></td></tr>`
   );
   $.ajax({
      url: "/api/biodata-rest/",
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
                     <div class="row">
                        <div class="col-md"> ${number}</div>
                        <div class="col-md"> ${result[i].fullName}</div>
                        <div class="col-md"> ${result[i].email}</div>


                        <div class="col-md mt-3">
                        <h5 class="">
                           <a onclick="get_data_byid( ${result[i].id},'edit')" class="mr-2 " data-toggle="modal" data-target="#addModal"
                              href="#" id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
                           <a onclick="hapus(${result[i].id})" class="mr-2" data-toggle="modal" data-target="#addModal" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                           <a onclick="detailData(${result[i].id})" class="mr-2" data-toggle="modal" data-target="#addModal" href="#"
                              id="showAddData"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
                        </h5>
                        </div>
                     </div>
                  </td>
                  </tr> `
               );
               number++;
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

// get data by id Biodata
function get_data_byid(id, action) {
   $("#action").val(action);
   if (action == "detail") {
      $(".modal-judul").text("Detail Pelamar ");
      $("#sava_button").attr("disabled", true);
      $(".x-hide").hide();
   } else {
      $(".modal-judul").text("Edit Biodata");
      $(".get_biodata").attr("disabled", false);
      // $(".x-email").attr("disabled", true);
   }
   $.ajax({
      url: "/api/biodata-rest/" + id,
      type: "get",
      contentType: "application/json",
      success: function (result) {
         $("#get_form_biodata")[0].reset();

         get_marital(result.maritalStatus.id);
         get_religion(result.religion.id);
         get_identitas(result.identityType.id);

         $("#get_createdBy").val(result.createdBy);
         $("#get_createdOn").val(result.createdOn);

         $("#get_id").val(result.id);
         $("#get_companyid").val(result.companyId);
         $("#get_full_name").val(result.fullName);
         $("#get_nickname").val(result.nickName);
         $("#get_pob").val(result.pob);
         $("#get_dob").val(result.dob);

         var optValue = "";
         optValue += '<option value="">- Pilih -</option>';
         if (result.gender == true) {
            optValue += `<option value="true" selected="selected">Laki-laki</option>`;
            optValue += `<option value="false">Perempuan</option>`;
         } else {
            optValue += `<option value="true">Laki-laki</option>`;
            optValue += `<option value="false" selected="selected">Perempuan</option>`;
         }
         $("#get_gender").html(optValue);

         $("#get_hight").val(result.hight);
         $("#get_weight").val(result.weight);
         $("#get_nationality").val(result.nationality);
         $("#get_ethnic").val(result.ethnic);
         $("#get_hobby").val(result.hobby);
         $("#get_email").val(result.email);
         $("#get_no_hp1").val(result.phoneNumber1);
         $("#get_no_hp2").val(result.phoneNumber2);
         $("#get_parent_telphone").val(result.parentPhoneNumber);
         $("#get_child_secuence").val(result.childSequence);
         $("#get_how_many_brother").val(result.howManyBrothers);
         $("#get_marriage_year").val(result.marriageYear);
         $("#get_no_indentity").val(result.identityNo);

         $.ajax({
            url: "/api/address/bio/" + result.id,
            type: "get",
            contentType: "application/json",
            success: function (res) {
               let add = res[0];

               $("#get_addressid").val(add.id);
               $("#get_address1").val(add.address1);
               $("#get_address2").val(add.address2);
               $("#get_postal_code1").val(add.postalCode1);
               $("#get_postal_code2").val(add.postalCode2);
               $("#get_rt1").val(add.rt1);
               $("#get_rt2").val(add.rt2);
               $("#get_rw1").val(add.rw1);
               $("#get_rw2").val(add.rw2);
               $("#get_kelurahan1").val(add.kelurahan1);
               $("#get_kelurahan2").val(add.kelurahan2);
               $("#get_kecamatan1").val(add.kecamatan1);
               $("#get_kecamatan2").val(add.kecamatan2);
               $("#get_region1").val(add.region1);
               $("#get_region2").val(add.region2);
            },
            error: function () {
               swal.fire("", "Failed Load address", "error");
            }
         });
         $("#modal-biodata").modal("show");
      },

      error: function () {
         swal.fire("", "Failed to fetch the data", "error");
      }
   });
};

$("#add_button").click(function () {
   get_marital();
   get_religion();
   get_identitas();
   $(".modal-judul").text("Tambah Pelamar");
   $(".get_biodata").attr("disabled", false);
   $("#get_form_biodata")[0].reset();
   $("#get_id").val("");

   var optValue = "";
   optValue += '<option value="">- Pilih -</option>';
   optValue += `<option value="true">Laki-laki</option>`;
   optValue += `<option value="false">Perempuan</option>`;

   $("#get_gender").html(optValue);
   $("#action").val("add");
   $("#modal-biodata").modal("show");
});

$("#save_button").click(function () {
   var action = $("#action").val();

   var data = {
      id: $("#get_id").val(),
      fullName: $("#get_full_name").val(),
      nickName: $("#get_nickname").val(),
      pob: $("#get_pob").val(),
      dob: $("#get_dob").val(),
      gender: $("#get_gender").val(),
      hight: $("#get_hight").val(),
      weight: $("#get_weight").val(),
      nationality: $("#get_nationality").val(),
      ethnic: $("#get_ethnic").val(),
      hobby: $("#get_hobby").val(),
      email: $("#get_email").val(),
      phoneNumber1: $("#get_no_hp1").val(),
      phoneNumber2: $("#get_no_hp2").val(),
      parentPhoneNumber: $("#get_parent_telphone").val(),
      childSequence: $("#get_child_secuence").val(),
      howManyBrothers: $("#get_how_many_brother").val(),
      marriageYear: $("#get_marriage_year").val(),
      identityNo: $("#get_no_indentity").val(),
      companyId: $("#get_companyid").val(),

      religion: {
         id: $("#get_religion").val()
      },
      maritalStatus: {
         id: $("#get_marital_status").val()
      },
      identityType: {
         id: $("#get_type_identity").val()
      },

      biodataId: {
         id: $("#get_id").val()
      },
      idA: $("#get_addressid").val(),
      address1: $("#get_address1").val(),
      address2: $("#get_address2").val(),
      rt1: $("#get_rt1").val(),
      rt2: $("#get_rt2").val(),
      rw1: $("#get_rw1").val(),
      rw2: $("#get_rw2").val(),
      kelurahan1: $("#get_kelurahan1").val(),
      kelurahan2: $("#get_kelurahan2").val(),
      kecamatan1: $("#get_kecamatan1").val(),
      kecamatan2: $("#get_kecamatan2").val(),
      region1: $("#get_region1").val(),
      region2: $("#get_region2").val(),
      postalCode1: $("#get_postal_code1").val(),
      postalCode2: $("#get_postal_code2").val()
   };

   //Mengambil nilai inputan
   var fullName = $("#get_full_name").val();
   var nickName = $("#get_nickname").val();
   var pob = $("#get_pob").val();
   var dob = $("#get_dob").val();
   var gender = $("#get_gender").val();
   var email = $("#get_email").val();
   var phoneNumber1 = $("#get_no_hp1").val();
   var phoneNumber1 = $("#get_no_hp1").val();
   var parentPhoneNumber = $("#get_parent_telphone").val();
   var childSequence = $("#get_child_secuence").val();
   var howManyBrothers = $("#get_how_many_brother").val();
   var religion = $("#get_religion").val();
   var maritalStatus = $("#get_marital_status").val();
   var identityType = $("#get_type_identity").val();
   var identityNo = $("#get_no_indentity").val();
   var hight = $("#get_hight").val();
   var weight = $("#get_weight").val();
   var nationality = $("#get_nationality").val();
   var address1 = $("#get_address1").val();
   var address2 = $("#get_address2").val();
   var rt1 = $("#get_rt1").val();
   var rt2 = $("#get_rt2").val();
   var rw1 = $("#get_rw1").val();
   var rw2 = $("#get_rw2").val();
   var kelurahan1 = $("#get_kelurahan1").val();
   var kelurahan2 = $("#get_kelurahan2").val();
   var kecamatan1 = $("#get_kecamatan1").val();
   var kecamatan2 = $("#get_kecamatan2").val();
   var region1 = $("#get_region1").val();
   var region2 = $("#get_region2").val();
   // ending inputan

   console.log(identityType)
   if (action == "add") {
      type = "post";
   } else if (action == "edit") {
      type = "put";
   }

   if (fullName == "" || null) {
      swal.fire("Required", "Mohon isi nama lengkap anda", "info");
   } else if (nickName == "" || null) {
      swal.fire("Required", "Mohon isi nama Panggilan anda", "info");
   } else if (pob == "" || null) {
      swal.fire("Required", "Mohon isi nama Tempat Lahir anda", "info");
   } else if (dob == "" || null) {
      swal.fire("Penting", "Mohon isi nama Tanggal Lahir anda", "question");
   } else if (gender == "" || null) {
      swal.fire("Penting", "Anda belum memilih jenis kelamin.", "question");
   } else if (religion == "" || null) {
      swal.fire("Penting", "Anda belum memilih Agama.", "question");
   } else if (hight == "" || null) {
      swal.fire("Required", "Anda belum mengisi field Tinggi badan.", "question");
   } else if (weight == "" || null) {
      swal.fire("Required", "Anda belum mengisi field berat badan.", "question");
   } else if (nationality == "" || null) {
      swal.fire("Required", "Anda belum mengisi Kewarganegaraan Anda.", "question");
   } else if (identityType == "" || null) {
      swal.fire("Penting", "Anda belum memilih tipe identitas.", "question");
   } else if (email == "" || null) {
      swal.fire("Required", "Pastikan email telah diisi.", "info");
   } else if (phoneNumber1 == "" || null) {
      swal.fire("Required", "Pastikan nomor HP kamu telah diisi.", "info");
   } else if (parentPhoneNumber == "" || null) {
      swal.fire("Required", "Pastikan nomor HP Orang tua telah diisi.", "info");
   } else if (childSequence > howManyBrothers) {
      swal.fire("Penting", "Urutan kelahiran tidak boleh lebih dari jumlah saudara", "info");
   } else if (childSequence == "" || null) {
      swal.fire("Required", "Field anak ke belum diisi.", "info");
   } else if (howManyBrothers == "" || null) {
      swal.fire("Required", "Banyak saudara anda belum diisi.", "info");
   } else if (maritalStatus == "" || null) {
      swal.fire("Penting", "Status pernikahanmu?", "question");
   } else if (validateEmail(email) == false) {
      swal.fire("Fatal", "Email yang anda masukkan tidak valid", "warning");
   } else if (address1 == "" || null) {
      swal.fire("Required", "Anda belum mengisi alamat asal.", "question");
   } else if (address2 == "" || null) {
      swal.fire("Required", "Anda belum mengisi alamat Domisili.", "question");
   } else if (rt1 == "" || null) {
      swal.fire("Required", "Anda belum mengisi Nomor Rt.", "question");
   } else if (rt2 == "" || null) {
      swal.fire("Required", "Anda belum mengisi Nomor Rt domisili.", "question");
   } else if (rw1 == "" || null) {
      swal.fire("Required", "Anda belum mengisi Nomor rw.", "question");
   } else if (rw2 == "" || null) {
      swal.fire("Required", "Anda belum mengisi Nomor rw domisili.", "question");
   } else if (kelurahan1 == "" || null) {
      swal.fire("Required", "Anda belum mengisi kelurahan.", "question");
   } else if (kelurahan2 == "" || null) {
      swal.fire("Required", "Anda belum mengisi kelurahan Domisili.", "question");
   } else if (kecamatan1 == "" || null) {
      swal.fire("Required", "Anda belum mengisi kecamatan.", "question");
   } else if (kecamatan2 == "" || null) {
      swal.fire("Required", "Anda belum mengisi kecamatan Domisili.", "question");
   } else if (region1 == "" || null) {
      swal.fire("Required", "Anda belum mengisi kecamatan.", "question");
   } else if (region2 == "" || null) {
      swal.fire("Required", "Anda belum mengisi kecamatan Domisili.", "question");
   } else {
      // cek email-no identitas-no hp
      $.ajax({
         url: "/api/biodata-rest/",
         type: "get",
         contentType: "application/json",
         success: function (cek) {
            if (cek.length > 0) {
               var cek_eml = false;
               var cek_no_idn = false;
               var cek_no_hp = false;

               for (let i = 0; i < cek.length; i++) {
                  if (email == cek[i].email) {
                     cek_eml = true;
                  }
                  if (identityNo == cek[i].identityNo && identityType == cek[i].identityType.id) {
                     cek_no_idn = true;
                  }
                  if (phoneNumber1 == cek[i].phoneNumber1) {
                     cek_no_hp = true;
                  }
               }

               if (type == 'put') {
                  save
                  $.ajax({
                     url: "/api/biodata-rest",
                     type: type,
                     contentType: "application/json",
                     data: JSON.stringify(data),
                     success: function (result) {
                        $("#get_form_biodata")[0].reset();
                        get_all_data();
                        Toast.fire({
                           icon: 'success',
                           title: "Data berhasil di" + action + "."
                        })
                        $("#modal-biodata").modal("hide");
                     },
                     error: function () {
                        Swal.fire("", "Failed to " + action + " data", "error");
                     }
                  });
               } else {

                  if (cek_eml == true) {
                     swal.fire("Forbidden", "Email telah digunakan.", "warning");
                  } else if (cek_no_idn == true) {
                     swal.fire("Forbidden", "Nomor Identitas tidak boleh sama.", "warning");
                  } else if (cek_no_hp == true) {
                     swal.fire("Forbidden", "Nomor HP anda tidak boleh sama.", "warning");
                  } else {

                     //save
                     $.ajax({
                        url: "/api/biodata-rest",
                        type: type,
                        contentType: "application/json",
                        data: JSON.stringify(data),
                        success: function (result) {
                           $("#get_form_biodata")[0].reset();
                           get_all_data();
                           Toast.fire({
                              icon: 'success',
                              title: "Data berhasil di" + action + "."
                           })
                           $("#modal-biodata").modal("hide");
                        },
                        error: function () {
                           Swal.fire("", "Failed to " + action + " data", "error");
                        }
                     });
                  };
               }
            };
         }
      });
   };
});

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
            url: "/api/biodata-rest/" + id,
            type: "delete",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (result) {
               get_all_data();
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

$(function () {
   $('#get_dob').daterangepicker({
      singleDatePicker: true,
      showDropdowns: true,
      opens: 'left',
      minYear: 1980,
      maxYear: parseInt(moment().format('YYYY'), 10),
      locale: {
         format: 'YYYY-MM-DD'
      }
   });
});

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

// validasi inputan email 
function validateEmail(em) {
   var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
   return re.test(em);
}

// get detail biodata
function detailData(id) {
   $.ajax({
      url: "/api/biodata-rest/" + id,
      type: "get",
      contentType: "application/json",
      success: function (result) {
         $("#get_form_biodata")[0].reset();
         get_marital(result.maritalStatus.id);
         get_religion(result.religion.id);
         get_identitas(result.identityType.id);
         $("#get_id").val(result.id);

         var gend = result.gender;
         var kelamin;
         if (gend == true) {
            kelamin = "Laki-laki";
         } else {
            kelamin = "Perempuan";
         }

         $("#biodata-rows").html(`
         <tr>
            <td>Nama Lengkap</td>
            <td>:    ${result.fullName}</td>
         </tr>
            <tr>
               <td>Nama Panggilan</td>
               <td>:    ${result.nickName}</td>
            </tr>
            <tr>
               <td>Kontak</td>
               <td>:   ${result.email} / ${result.phoneNumber1}</td>
            </tr>
            <tr>
               <td>Tempat, Tanggal Lahir</td>
               <td>:    ${result.pob}, ${result.dob}</td>
            </tr>
            <tr>
               <td>Jenis Kelamin, Tinggi(cm), Berat(Kg)</td>
               <td>:    ${kelamin}, ${result.hight},  ${result.weight}   </td>
            </tr>
            <tr>
               <td>Agama</td>
               <td>:    ${result.religion.name}</td>
            </tr>
            <tr>
               <td>Kewarganegaraan, Suku Bangsa</td>
               <td>:    ${result.nationality}, ${result.ethnic}</td>
            </tr>
            <tr>
               <td>Kegemaran / Hobi</td>
               <td>:    ${result.hobby}</td>
            </tr>
            <tr>
               <td>Jenis & Nomor Identitas</td>
               <td>:    ${result.identityType.name} - ${result.identityNo}</td>
            </tr>
            <tr>
               <td>Status & Tahun Pernikahan</td>
               <td>:    ${result.maritalStatus.name} - ${result.marriageYear}</td>
            </tr>
         
         `);

         $("#detailBiodata").modal("show");
      },

      error: function () {
         swal.fire("", "Failed to fetch the data", "error");
      }
   });
};

// get edit dengan modal full fitur 
function get_edit() {
   $("#detailBiodata").modal("hide");
   var id = $("#get_id").val();
   get_data_byid(id, 'edit');
}