package jp.ac.neec.it.k020c1094.endo06

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class SendConfirmDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val msg = requireArguments().getString("msg", "")

        val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.dialog_title)
            builder.setMessage(msg)
            builder.setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickListener())
            builder.setNegativeButton(R.string.dialog_btn_ng, DialogButtonClickListener())
            builder.create()
        }
        return dialog ?: throw IllegalStateException("アクティビティがnullです")
    }

    private inner class DialogButtonClickListener : DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface, which: Int) {
            var msg = ""
            when (which) {
                DialogInterface.BUTTON_POSITIVE ->
                    msg = getString(R.string.dialog_ok_toast)
                DialogInterface.BUTTON_NEGATIVE ->
                    msg = getString(R.string.dialog_ng_toast)
            }
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
    }
}
