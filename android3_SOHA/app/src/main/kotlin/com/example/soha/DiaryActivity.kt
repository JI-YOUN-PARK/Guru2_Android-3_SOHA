package com.example.soha

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_diary.*
// import kotlinx.android.synthetic.main.diary_list.*

class DiaryActivity : AppCompatActivity() {

    var date: String = ""
    var str: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            diary1View.visibility = View.VISIBLE
            diary1View.text = String.format("%d년 %d월 %d일", year, month + 1, dayOfMonth)
            date = String.format("%d년 %d월 %d일", year, month + 1, dayOfMonth)
            check(date)
        }

        val sharedPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)
        str = sharedPreferences.getString(date, "").toString()
        diary2View.text = str
    }

    fun saveDiary(k: String, m: String) {
        val sharedPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(k, m) // ?
        editor.commit()
    }

    fun deleteDiary(k: String) {
        val sharedPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.remove(k)
        editor.commit()
    }

    fun check(d: String) {
        // 일기 내용 보여주기
        val sharedPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)
        str = sharedPreferences.getString(d, "").toString()
        diary2View.text = str

        if(str != "") {
            btnSaveDiary.visibility = View.INVISIBLE
            diaryEditView.visibility = View.INVISIBLE
            diary2View.visibility = View.VISIBLE
            btnModifyDiary.visibility = View.VISIBLE
            btnDeleteDiary.visibility = View.VISIBLE
        }

        else {
            btnSaveDiary.visibility = View.VISIBLE
            diaryEditView.visibility = View.VISIBLE
            diary2View.visibility = View.INVISIBLE
            btnModifyDiary.visibility = View.INVISIBLE
            btnDeleteDiary.visibility = View.INVISIBLE
            diaryEditView.setText("")
        }

        // 삭제 버튼 클릭시
        btnDeleteDiary.setOnClickListener {
            deleteDiary(date)
            // deleteDiary(date)
            btnSaveDiary.visibility = View.VISIBLE
            diaryEditView.visibility = View.VISIBLE
            diary2View.visibility = View.INVISIBLE
            btnModifyDiary.visibility = View.INVISIBLE
            btnDeleteDiary.visibility = View.INVISIBLE
            diaryEditView.setText("")
        }

        // 수정 버튼 클릭시
        btnModifyDiary.setOnClickListener {
            btnSaveDiary.visibility = View.VISIBLE
            diaryEditView.visibility = View.VISIBLE
            diary2View.visibility = View.INVISIBLE
            btnModifyDiary.visibility = View.INVISIBLE
            btnDeleteDiary.visibility = View.INVISIBLE
            diaryEditView.setText(str)
        }

        // 저장 버튼 클릭시
        btnSaveDiary.setOnClickListener {
            // 내용 저장
            str = diaryEditView.getText().toString()
            saveDiary(date, str)
            diary2View.text = str
            diaryEditView.setText(str)

            if(str == "") {}
            else {
                btnSaveDiary.visibility = View.INVISIBLE
                diaryEditView.visibility = View.INVISIBLE
                diary2View.visibility = View.VISIBLE
                btnModifyDiary.visibility = View.VISIBLE
                btnDeleteDiary.visibility = View.VISIBLE
            }
        }
    }
}
