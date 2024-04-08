package org.lotka.xenonx.presentation.ui.screens.plp.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Card

import androidx.compose.material.Icon

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.lotka.xenonx.R
import org.lotka.xenonx.domain.enums.IsItemPinnedStatus
import org.lotka.xenonx.domain.enums.ListingType
import org.lotka.xenonx.domain.enums.UserVerificationStatus
import org.lotka.xenonx.domain.model.model.plp.PlpItemResultModel
import org.lotka.xenonx.presentation.composables.FastImage
import org.lotka.xenonx.presentation.theme.DescriptionTextColor
import org.lotka.xenonx.presentation.theme.KilidTypography
import org.lotka.xenonx.presentation.theme.LockIconColor
import org.lotka.xenonx.presentation.theme.TelegramBackGround
import org.lotka.xenonx.presentation.theme.TelegramBackGroundColor
import org.lotka.xenonx.presentation.theme.TelegramColor
import org.lotka.xenonx.presentation.theme.TelegrampinkColor
import org.lotka.xenonx.presentation.theme.kilidDarkBackgound
import org.lotka.xenonx.presentation.theme.kilidDarkTexts
import org.lotka.xenonx.presentation.theme.kilidWhiteBackgound
import org.lotka.xenonx.presentation.theme.kilidWhiteTexts
import org.lotka.xenonx.util.extension.addThousandsSeparator


@Composable
fun PlpItem(
    isDarkTheme: Boolean,
    item: PlpItemResultModel,
    screen: Configuration,
    onMoreClicked: (id: Int) -> Unit,
    onClicked: (id: Int) -> Unit,
    onLadderUpClick: (id: Int) -> Unit,
    onFeaturedClick: (id: Int) -> Unit,
    index: Int,
    onCardClick: Boolean

    ) {
    Card(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp,
                )
            )
            .padding(vertical = 4.dp, horizontal = 12.dp)
            .fillMaxWidth()
            .height(90.dp)
            .clickable {
//        item?.id?.let { onClicked(it, item.) }
            },
        elevation = 2.dp,
        contentColor = if (onCardClick) Color.Green else Color.White,
        backgroundColor = if (isDarkTheme) Color.White else Color.Gray,


        ) {
        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "narmak", modifier = Modifier.padding(start = 8.dp, top = 8.dp))

                Icon(painter = painterResource(id = R.drawable.menu),
                    contentDescription =null,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 8.dp)
                        .size(24.dp)
                        .padding(end = 12.dp, top = 8.dp)
                )

//                Text(text = "neslonmandella - jadi - folan", modifier = Modifier.padding(8.dp))


            }



            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "narmak - danpzishki - jahfari", modifier = Modifier.padding(start = 8.dp, top = 8.dp))

                Text(text = "narmak", modifier = Modifier.padding(start = 8.dp, top = 8.dp))

//                Text(text = "neslonmandella - jadi - folan", modifier = Modifier.padding(8.dp))


            }
        }





    }

}









