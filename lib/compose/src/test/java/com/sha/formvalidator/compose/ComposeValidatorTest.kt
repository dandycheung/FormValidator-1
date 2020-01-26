package com.sha.formvalidator.compose

import org.junit.Test

class ComposeValidatorTest {

    @Test
    fun `constructor(List), should work correctly`() {
        val composeValidator = ComposeValidator(listOf(mandatory<String>(), mandatory()))
        assert(composeValidator.models.size == 2)
    }

    @Test
    fun `constructor(vararg), should work correctly`() {
        val composeValidator = ComposeValidator(mandatory<String>(), mandatory<String>())
        assert(composeValidator.models.size == 2)
    }

    @Test
    fun `isValid, should invoke validator#isValid`() {
        val m1 = FakeValidatable.create()
        val m2 = FakeValidatable.create()
        val composeValidator = ComposeValidator(m1, m2)

        composeValidator.isValid

        assert(m1.isValidInvoked)
        assert(m2.isValidInvoked)
    }
}