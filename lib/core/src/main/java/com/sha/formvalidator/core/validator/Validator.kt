package com.sha.formvalidator.core.validator

abstract class AbsValidator<V>: Validator<V> {
    override var value: V? = null
    override var onValidate: MutableList<((Boolean) -> Unit)?> = mutableListOf()
    override var onError: MutableList<((String) -> Unit)?> = mutableListOf()

    fun addOnValidateListener(listener: ((Boolean) -> Unit)?): AbsValidator<V> {
        onValidate.add(listener)
        return this
    }

    fun addOnErrorListener(listener: ((String) -> Unit)?): AbsValidator<V> {
        onError.add(listener)
        return this
    }

    fun removeListeners() {
        onValidate.clear()
        onError.clear()
    }
}

interface Validator<V>: ValidatorType {
    var value: V?
}

interface ValidatorType {
    fun validate(): Boolean
    var errorMessage: String
    var onValidate: MutableList<((Boolean) -> Unit)?>
    var onError: MutableList<((String) -> Unit)?>
    val isValid: Boolean
        get() {
            val valid = validate()
            onValidate.forEach { it?.invoke(valid) }
            if (!valid)
                onError.forEach { it?.invoke(errorMessage) }
            return valid
        }
}