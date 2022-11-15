package jp.ac.neec.it.k020c1094.endo06

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btConfirm = findViewById<Button>(R.id.btConfirm)
        var btSend = findViewById<Button>(R.id.btSend)
        var btClear = findViewById<Button>(R.id.btClear)

        val listener = ButtonClickListener()
        btConfirm.setOnClickListener(listener)
        btSend.setOnClickListener(listener)

        btClear.setOnClickListener(listener)

        Toast.makeText(
            applicationContext,
            getString(R.string.clear_toast),
            Toast.LENGTH_LONG
        ).show()
    }

    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            var etName = findViewById<EditText>(R.id.etName)
            var etNameRubi = findViewById<EditText>(R.id.etNameRubi)
            var etNameEmailAddress = findViewById<EditText>(R.id.etNameEmailAddress)
            var etPhoneNumber = findViewById<EditText>(R.id.etPhoneNumber)
            var etPost = findViewById<EditText>(R.id.etPost)
            var edYear = findViewById<EditText>(R.id.edYear)
            var edMonth = findViewById<EditText>(R.id.edMonth)
            var edDate = findViewById<EditText>(R.id.edDate)
            var group = findViewById<RadioGroup>(R.id.group)
            var radioMale = findViewById<RadioButton>(R.id.radioMale)
            var radioFemale = findViewById<RadioButton>(R.id.radioFemale)
            var radioGender = findViewById<RadioButton>(R.id.radioGender)
            var etContact = findViewById<EditText>(R.id.etContact)



            when (view.id) {
                R.id.btConfirm -> {
                    // kara true
                    var count = 0;
                    if (TextUtils.isEmpty(etName.text.toString())) count++
                    if (TextUtils.isEmpty(etNameRubi.text.toString())) count++
                    if (TextUtils.isEmpty(etNameEmailAddress.text.toString())) count++
                    if (TextUtils.isEmpty(etPhoneNumber.text.toString())) count++
                    if (TextUtils.isEmpty(etPost.text.toString())) count++
                    if (TextUtils.isEmpty(edYear.text.toString())) count++
                    if (TextUtils.isEmpty(edMonth.text.toString())) count++
                    if (TextUtils.isEmpty(edDate.text.toString())) count++
                    if (TextUtils.isEmpty(etContact.text.toString())) count++
                    val checkedId: Int = group.checkedRadioButtonId
                    if (checkedId !== -1) {

                    } else {
                        count++
                    }

                    println(count)

                    if (count == 0) {
                        val dialogFragment = SendConfirmDialogFragment()
                        val args = Bundle()
                        args.putString("msg", getString(R.string.dialog_msg))
                        dialogFragment.arguments = args
                        dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")
                    } else {
                        val dialogFragment = SendConfirmDialogFragment()
                        val args = Bundle()
                        args.putString("msg", getString(R.string.dialog_msg_err, count))
                        dialogFragment.arguments = args
                        dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")
                    }


                }
                R.id.btSend -> {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.send_toast, etNameEmailAddress.text.toString()),
                        Toast.LENGTH_LONG
                    ).show()

                    etName.setText("")
                    etNameRubi.setText("")
                    etNameEmailAddress.setText("")
                    etPhoneNumber.setText("")
                    etPost.setText("")
                    edYear.setText("")
                    edMonth.setText("")
                    edDate.setText("")
                    group.clearCheck()
                    etContact.setText("")

                }
                R.id.btClear -> {
                    etName.setText("")
                    etNameRubi.setText("")
                    etNameEmailAddress.setText("")
                    etPhoneNumber.setText("")
                    etPost.setText("")
                    edYear.setText("")
                    edMonth.setText("")
                    edDate.setText("")
                    group.clearCheck()
                    etContact.setText("")
                    Toast.makeText(
                        applicationContext, R.string.clear_toast,
                        Toast.LENGTH_LONG
                    ).show()


                }
            }
        }


    }

}