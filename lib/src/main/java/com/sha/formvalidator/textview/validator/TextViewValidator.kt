package com.sha.formvalidator.textview.validator

import android.widget.TextView

/**
 * Validator abstract class. To be used with FormEditText
 *
 */
abstract class TextViewValidator(var errorMessage: String = "") {

    /**
     * Should check if the [TextView] is valid.
     *
     * @param tv the [TextView] under evaluation
     * @return true if the edittext is valid, false otherwise
     */
    abstract fun isValid(tv: TextView): Boolean

    fun hasErrorMessage(): Boolean = errorMessage.isNotEmpty()
}