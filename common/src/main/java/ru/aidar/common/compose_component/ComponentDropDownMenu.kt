package ru.aidar.common.compose_component

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.aidar.common.compose_component.model.DropDownModel

@Composable
fun ComponentDropDownMenu(
    onDismissRequest: () -> Unit,
    expanded: Boolean,
    items: Array<DropDownModel>,
) {
    DropdownMenu(expanded = expanded, onDismissRequest = onDismissRequest) {
        items.forEach {
            DropdownMenuItem(
                text = { ComponentDropDownMenuText(text = stringResource(it.text)) },
                onClick = it.action,
                trailingIcon = {
                    Icon(
                        painter = painterResource(it.trailingImage),
                        contentDescription = null,
                    )
                },
            )
        }
    }
}
