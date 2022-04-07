package me.mason.bpmtester

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("session")
class Profile {
    var left: Char = 'X'
    var right: Char = 'Z'
}