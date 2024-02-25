package org.lotka.xenonx.util.form_validator

class FormValidator {

    var formIsValid: Boolean = true

    fun createForm(formFields: List<FormField>): FormValidator {
        formFields.forEach {
            formIsValid = if (it.isValid) formIsValid else false
        }
        return this
    }
}