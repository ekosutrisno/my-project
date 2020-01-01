package com.xsis.xsis.dto;

/**
 * EmailDto
 */
public class EmailDto {
  private String penerima;
  private String judul;
  private String konten;

  public String getPenerima() {
    return penerima;
  }

  public void setPenerima(String penerima) {
    this.penerima = penerima;
  }

  public String getJudul() {
    return judul;
  }

  public void setJudul(String judul) {
    this.judul = judul;
  }

  public String getKonten() {
    return konten;
  }

  public void setKonten(String konten) {
    this.konten = konten;
  }

}