package com.sha.formvalidator.compose

import androidx.compose.State


/**
 * The base form validator that all validators must extend.
 */
open class AbstractComposeFormValidator<T : ValidatableTextModel> {
    private var fields: List<State<T>> = emptyList()
    val isValid: Boolean
        get() {
            if(fields.isEmpty()) return false
            var isValid = true
            fields.forEach {
                val fieldValid = it.value.isValid
                isValid = fieldValid && isValid
            }
            return isValid
        }
    /**
     * create an instance with list of fields to be validated.
     */
    constructor(fields: List<State<T>>) {
        this.fields = fields
    }

    /**
     * create an instance with var args of fields to be
     * validated.
     */
    @SafeVarargs
    constructor(vararg fields: State<T>) {
        this.fields = fields.asList()
    }
}
