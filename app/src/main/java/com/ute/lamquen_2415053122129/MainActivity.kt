package com.ute.lamquen_2415053122129

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.lamquen_2415053122129.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var luotCuoi_2129: LuotNhan? = null
    private var boDemLuot = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtSinhVien.text = "NGUYỄN MINH NGHĨA — 2415053122129 — TRY20"

        binding.btnKiemTra.setOnClickListener {
            kiemTra_2129()
        }
        binding.btnXoa.setOnClickListener {
            xoa_2129()
        }
    }

    fun kiemTra_2129() {
        val tenChuan = binding.edtTen.text.toString().chuanHoaTen_2129()
        val soLuongStr = binding.edtSoLuong.text.toString().trim()
        val soLuong = soLuongStr.toIntOrNull()
        if (tenChuan.length !in 2..40) {
            luotCuoi_2129 = null
            binding.txtKetQua.text = "Lỗi: Tên phải từ 2 đến 40 ký tự"
            binding.txtMaLuot.text = ""
            return
        }
        if (soLuong == null || soLuong !in 1..9) {
            luotCuoi_2129 = null
            binding.txtKetQua.text = "Lỗi: Số lượng phải là số nguyên từ 1 đến 9"
            binding.txtMaLuot.text = ""
            return
        }
        boDemLuot++
        val maMoi = QuyTacPhieu_2129.taoMaPhieu_2129(boDemLuot)
        luotCuoi_2129 = LuotNhan(
            maLuot_2129 = maMoi,
            hoTen_2129 = tenChuan,
            soLuong_2129 = soLuong
        )
        luotCuoi_2129?.let { model ->
            binding.txtKetQua.text = "Xin chào ${model.hoTen_2129}, số lượng: ${model.soLuong_2129}"
            binding.txtMaLuot.text = model.maLuot_2129
        }
    }
    fun xoa_2129() {
        luotCuoi_2129 = null
        binding.edtTen.text?.clear()
        binding.edtSoLuong.text?.clear()
        binding.txtKetQua.text = ""
        binding.txtMaLuot.text = ""
    }
}