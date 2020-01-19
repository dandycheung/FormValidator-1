package com.sha.formvalidator.compose


/**
 * The base form validator that all validators must extend.
 */
open class ComposeValidator {
    private var fields: List<ValidatableModel<*>> = emptyList()
    val isValid: Boolean
        get() {
            if(fields.isEmpty()) return false
            var isValid = true
            fields.forEach {
                val fieldValid = it.isValid
                isValid = fieldValid && isValid
                it.validate()
            }
            return isValid
        }
    /**
     * create an instance with list of fields to be validated.
     */
    constructor(models: FormValidation) {
        this.fields = models.list
    }

    /**
     * create an instance with list of fields to be validated.
     */
    constructor(fields: List<ValidatableModel<*>>) {
        this.fields = fields
    }

    /**
     * create an instance with var args of fields to be
     * validated.
     */
    @SafeVarargs
    constructor(vararg fields: ValidatableModel<*>) {
        this.fields = fields.asList()
    }
}
