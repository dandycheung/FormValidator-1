package com.sha.formvalidator.handler

import android.graphics.Color
import android.util.AttributeSet
import android.widget.CompoundButton

import com.sha.formvalidator.core.validator.composite.AllValidator
import com.sha.formvalidator.factory.AttrValidatorFactory
import com.sha.formvalidator.factory.BooleanAttrValidatorFactory

class CompoundButtonValidationHandler(
        override val view: CompoundButton,
        attrs: AttributeSet?
) : AbsValidationHandler<Boolean>() {
    override lateinit var validator: AllValidator<Boolean>
    override var attrValidatorFactory: AttrValidatorFactory<Boolean> = BooleanAttrValidatorFactory
    override val value: Boolean
        get() = view.isChecked
    private var originalColor: Int = -1

    init {
        originalColor = view.currentTextColor
        setup(attrs, view.context)
    }

    override fun showError(e: String?) {
        if (e == null) {
            view.setTextColor(originalColor)
            return
        }
        view.setTextColor(Color.RED)
    }
}