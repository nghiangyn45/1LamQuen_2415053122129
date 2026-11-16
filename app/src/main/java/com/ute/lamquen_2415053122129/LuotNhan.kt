package com.ute.lamquen_2415053122129

data class LuotNhan(
    val maLuot_2129: String,
    val hoTen_2129: String,
    val soLuong_2129: Int
)
fun String.chuanHoaTen_2129(): String {
    return this.trim()
}

object QuyTacPhieu_2129 {
    fun taoMaPhieu_2129(soThuTu: Int): String {
        return "L$soThuTu"
    }
}