package com.sha.formvalidator.validator

import com.sha.formvalidator.core.text.validator.NumericRangeValidator
import com.sha.formvalidator.core.text.validator.TextValidator
import org.junit.Before
import org.junit.Test

class NumericLengthRangeValidatorTest {
    lateinit var validator: TextValidator

    @Before
    fun setup() {
        validator = NumericRangeValidator("Invalid!", 1, 5)
    }

    @Test
    fun validate_valid() {
        assert(validator.isValid("1"))
    }

    @Test
    fun validate_invalid() {
        assert(!validator.isValid("6"))
    }
}