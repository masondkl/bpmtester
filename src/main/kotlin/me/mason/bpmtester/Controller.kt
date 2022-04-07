package me.mason.bpmtester

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestMethod.POST


@Controller
@Scope("session")
class Controller {
    @Autowired
    private lateinit var profile: Profile

    @RequestMapping(value=["/"], method=[GET])
    fun index(model: Model): String {
        model.addAttribute("profile", profile)
        return "index"
    }

    @RequestMapping(value=["/edit"], method=[GET])
    fun edit(model: Model): String {
        model.addAttribute("profile", profile)
        return "edit"
    }

    @RequestMapping(value=["/edit"], method=[POST])
    fun add(
        @ModelAttribute profile: Profile,
        errors: BindingResult,
        model: Model
    ): String {
        this.profile.left = profile.left.uppercaseChar()
        this.profile.right = profile.right.uppercaseChar()
        return "redirect:/"
    }
}