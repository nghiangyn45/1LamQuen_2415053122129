package com.ute.lamquen_2415053122129

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.lamquen_2415053122129.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var luotCuoi_2129: LuotNhan? = null
    var phienNhan_2129 = PhienNhan(daNhan_2129 = 0)
    private var boDemLuot = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtSinhVien.text = "NGUYỄN MINH NGHĨA — 2415053122129 — TRY20"
        capNhatUIPhien()

        binding.btnGhiNhan.setOnClickListener {
            ghiNhan_2129()
        }
        binding.btnXoa.setOnClickListener {
            xoa_2129()
        }
    }

    fun ghiNhan_2129() {
        val tenChuan = binding.edtTen.text.toString().chuanHoaTen_2129()
        val soLuongStr = binding.edtSoLuong.text.toString().trim()
        val soLuong = soLuongStr.toIntOrNull()
        // Kiểm tra hợp lệ Tên (2-40 ký tự)
        if (tenChuan.length !in 2..40) {
            luotCuoi_2129 = null
            binding.txtKetQua.text = "Lỗi: Tên phải từ 2 đến 40 ký tự"
            binding.txtMaLuot.text = ""
            return
        }

        // Kiểm tra hợp lệ Số lượng (1-9)
        if (soLuong == null || soLuong !in 1..9) {
            luotCuoi_2129 = null
            binding.txtKetQua.text = "Lỗi: Số lượng phải là số nguyên từ 1 đến 9"
            binding.txtMaLuot.text = ""
            return
        }

        // Kiểm tra sức chứa (Tổng hiện tại + lượng mới <= 9)
        val tongMoi = phienNhan_2129.daNhan_2129 + soLuong
        if (tongMoi > 9) {
            luotCuoi_2129 = null
            binding.txtKetQua.text = "Lỗi: Vượt quá sức chứa tối đa 9 người!"
            binding.txtMaLuot.text = ""
            return
        }

        // Hợp lệ: cập nhật phiên, tăng mã lượt và hiển thị
        phienNhan_2129 = PhienNhan(daNhan_2129 = tongMoi)
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
        capNhatUIPhien()
    }

    fun xoa_2129() {
        luotCuoi_2129 = null
        phienNhan_2129 = PhienNhan(daNhan_2129 = 0)
        binding.edtTen.text?.clear()
        binding.edtSoLuong.text?.clear()
        binding.txtKetQua.text = ""
        binding.txtMaLuot.text = ""
        }
