package com.sha.formvalidatorsample.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sha.formvalidator.FormValidator
import com.sha.formvalidatorsample.R
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        validateOnClick()
        justCheck()
        validateOnClickUsingFormLayout()
    }

    private fun validateOnClickUsingFormLayout() {
        form.validateOnClick(btnValidateFormLayout) {
            toast("Validate Form layout result: $it")
        }
    }

    private fun validateOnClick() {
        FormValidator(etAllowEmpty, etAlpha, etPhone)
                .validateOnClick(findViewById<View>(R.id.btnValidateOnClick)) {
                    toast("Validate on Click result: $it")
                }
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT)
                .show()
    }

    private fun justCheck() {
        findViewById<View>(R.id.btnJustCheck).setOnClickListener {
            val isValid = FormValidator(etAllowEmpty, etAlpha, etPhone).isValid
            toast("Just check result: $isValid")
        }
    }

}
