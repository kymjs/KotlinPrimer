package com.kymjs.project3.unit5

import android.view.View

/**
 * Created by ZhangTao on 18/6/13.
 */
enum class Command {
    A, B, C, D
}

fun exec(command: Command) = when (command) {
    Command.A -> {
    }
    Command.B -> {
    }
    Command.C -> {
    }
    Command.D -> {
    }
}

sealed class SuperCommand {
    object A : SuperCommand()
    object B : SuperCommand()
    object C : SuperCommand()
    object D : SuperCommand()
    class E(var id: Int) : SuperCommand()
}

fun exec(view: View, superCommand: SuperCommand) = when (superCommand) {
    SuperCommand.A -> {
    }
    SuperCommand.B -> {
    }
    SuperCommand.C -> {
    }
    SuperCommand.D -> {
    }
    is SuperCommand.E -> {
    }
}
