package xyz.teamgravity.composepreviewdemo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import xyz.teamgravity.composepreviewdemo.ui.theme.ComposePreviewDemoTheme

@Composable
fun CustomButton(
    title: String,
    outlined: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (outlined) {
        OutlinedButton(
            onClick = onClick,
            shape = RectangleShape,
            contentPadding = PaddingValues(16.dp),
            modifier = modifier,
            border = BorderStroke(
                width = if (LocalInspectionMode.current) 3.dp else 1.dp,
                color = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = title
            )
        }
    } else {
        Button(
            onClick = onClick,
            shape = RectangleShape,
            contentPadding = PaddingValues(16.dp),
            modifier = modifier
        ) {
            Text(
                text = title
            )
        }
    }
}

@Preview
@PreviewLightDark
@Composable
fun CustomButtonPreview(
    @PreviewParameter(OutlinedParameterProvider::class) outlined: Boolean
) {
    ComposePreviewDemoTheme(
        dynamicColor = false
    ) {
        CustomButton(
            title = "Hello world!",
            outlined = outlined,
            onClick = {}
        )
    }
}

class OutlinedParameterProvider : PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean>
        get() = sequenceOf(false, true)
}