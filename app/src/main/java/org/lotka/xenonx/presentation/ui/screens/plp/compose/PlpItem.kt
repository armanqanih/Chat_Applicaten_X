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

    ) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        val isFeatured = item.isPremiumUser
        Card(
            modifier = Modifier
                .padding(4.dp)
                .background(if (isDarkTheme) kilidDarkBackgound else kilidWhiteBackgound)
                .clickable { onClicked(item.id) },
//        shape = RoundedCornerShape(8.dp) ,
//        border = BorderStroke( 1.dp  , if (isDarkTheme) kilidDarkBorders else kilidWhiteBorders ),
            elevation = 0.dp
        ) {


            val thumbnailUrl: String = item.smallProfileImage ?: "string"
            val thumbnailDrawable: Int? =
                if (thumbnailUrl == "string") R.drawable.nd_noimage else null

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(if (isDarkTheme) kilidDarkBackgound else kilidWhiteBackgound)
                    .padding(horizontal = 12.dp)
            ) {


                FastImage(
                    modifier = Modifier
                        .size(56.dp),
                    imageUrl = thumbnailUrl ?: thumbnailDrawable,
                    contentDescription = "Plp Item Image",
                    isRoundImage = true

                )


                // Advertisement Info
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .height(60.dp),
                    verticalArrangement = Arrangement.SpaceBetween,

                    ) {


                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .padding(start = 11.dp)
                            .fillMaxWidth()
                            .height(80.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically // Align items vertically in the row
                        ) {

                            if (item.isLockAccount) {
                                Icon(
                                    painter = painterResource(id = R.drawable.lock_account),
                                    contentDescription = "mute",
                                    modifier = Modifier.size(13.dp), tint = LockIconColor
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = item.userFirstName?.chunked(10) { it.trim() }
                                        ?.joinToString("\n") ?: "",
                                    style = KilidTypography.h4,
                                    color = if (isDarkTheme) kilidDarkTexts else kilidWhiteTexts,
                                )

                            } else {
                                Text(
                                    text = item.userFirstName?.chunked(10) { it.trim() }
                                        ?.joinToString("\n") ?: "",
                                    style = KilidTypography.h4,
                                    color = if (isDarkTheme) kilidDarkTexts else kilidWhiteTexts,
                                )
                            }



                            Spacer(modifier = Modifier.width(4.dp))
//
                            val painter = when (item.verificationStatus) {
                                UserVerificationStatus.NONE -> {
                                    null
                                }

                                UserVerificationStatus.BLUE_VERIFIED -> {
                                    R.drawable.pink_verify
                                }

                                UserVerificationStatus.GREEN_VERIFIED -> {
                                    R.drawable.vector
                                }

                                UserVerificationStatus.ADMIN_VERIFIED -> {
                                    R.drawable.pink_verify
                                }
                            }
                            FastImage(
                                imageUrl = painter,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            if (item.isSilent) {
                                Icon(
                                    painter = painterResource(id = R.drawable.mute_icon),
                                    contentDescription = "mute",
                                    modifier = Modifier.size(16.dp)
                                )

                            }
                        }

                        if (item.isTyping) {
                            Text(
                                text = "typing...",
                                style = KilidTypography.h3,
                                color = if (isDarkTheme) TelegrampinkColor else TelegrampinkColor,
                            )
                        }
                        //price per meter or rent
                        else {
                            Row() {

                                if (item.isSentAPicture) {
                                    FastImage(
                                        imageUrl = R.drawable.ic_ladder_up_yellow,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))

                                    Text(
                                        text = item.lastMessageText?.chunked(30) { it.trim() }
                                            ?.joinToString("...") ?: "",
                                        style = KilidTypography.h3,
                                        color = if (isDarkTheme) Color.White else DescriptionTextColor,
                                    )
                                } else {
                                    Text(
                                        text = item.lastMessageText?.chunked(30) { it.trim() }
                                            ?.joinToString("...") ?: "",
                                        style = KilidTypography.h3,
                                        color = if (isDarkTheme) Color.White else DescriptionTextColor,
                                    )
                                }
                            }

                        }


                    }


                }

                Column(

                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(8.dp)

                ) {
                    Row(

                    ) {
                        if (item.isUnreadMessage) {
                            Icon(
                                painter = painterResource(id = R.drawable.markread),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .size(12.dp), tint = LockIconColor

                            )
                        } else {
//                            mark read icon add
                        }



                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = item.lastMessageDate.toString(),
                            color = DescriptionTextColor,
                            style = KilidTypography.h3
                        )

                    }


                    when (item.isItemPinned) {
                        IsItemPinnedStatus.NONE -> {
                            null
                        }

                        IsItemPinnedStatus.ITEMPINNED -> {
                            Icon(
                                painter = painterResource(id = R.drawable.pinicon),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(23.dp)
                                    .clip(shape = CircleShape)
                            )
                        }

                        IsItemPinnedStatus.MESSAGENUMBER -> {
                            Box(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(color = TelegrampinkColor)
                                    .size(height = 23.dp, width = 31.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = item.numUnreadMessage.toString(),
                                    color = Color.White,
                                    style = KilidTypography.h2,
                                    textAlign = TextAlign.Center,

                                    )
                            }


                        }
                    }


                }


            }


        }


    }
    Spacer(modifier = Modifier.height(11.dp))
//        Divider(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 80.dp)
//        )


}











