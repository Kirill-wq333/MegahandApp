package com.example.megahandapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter


@Composable
fun MainTopBar(
    onClick:  () -> Unit,
    nameCategory: String,
    money: String
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White
            ),
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    modifier = Modifier
                        .clickable { onClick() },
                    painter = painterResource(R.drawable.chevron_right),
                    contentDescription = null
                )
                Text(
                    text = nameCategory,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_bold))),
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFF46423E).copy(0.1f),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clickable { onClick() }
                            .size(32.dp)
                            .background(
                                color = Color(0xFFE7D52F),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.surprisebox),
                            contentDescription = null
                        )
                    }
                    Text(
                        modifier = Modifier
                            .clickable { onClick() },
                        text = money,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold))),
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .clickable { onClick() },
                        painter = painterResource(R.drawable.location),
                        contentDescription = null
                    )
                    Image(
                        modifier = Modifier
                            .clickable { onClick() },
                        painter = painterResource(R.drawable.notifications),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun CenterMain(
    onClick: () -> Unit
){

    val imageUrl = rememberImagePainter(
        data = "https://mhand.ru/media/banner_app/Group_775_2.png",
        builder = {}
    )

    LazyColumn(
        modifier = Modifier
            .width(400.dp)
            .height(1300.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       item {
           LazyRow(
               modifier = Modifier
                   .padding(40.dp),
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.SpaceBetween
           ) {
               item {
                   LazyRowImageCenterMain()
               }
           }
       }
        item {
            LazyRowCodeCenterMain(
                money = "7200₽",
                onClick = {},
                scores = "Накоплено баллов",
                cashBack = "4% кешбэка",
                profile = "Заполните профиль чтобы получить больше",
            )
        }
        item {
            Box(
                modifier = Modifier
                    .width(363.dp)
                    .height(100.dp),
                contentAlignment = Alignment.TopEnd
            ){

                Icon(
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable { onClick() },
                    imageVector = ImageVector.vectorResource(R.drawable.cross),
                    contentDescription = null
                )
            }
        }
        item {

        }
    }
}


@Composable
fun LazyRowImageCenterMain(){

    Row(
        modifier =  Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            modifier = Modifier
                .size(92.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            AsyncImage(
                model = "https://s3-alpha-sig.figma.com/img/45c0/5ef9/36221f87dea04ad0c0420ac97e5fb1e3?Expires=1732492800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=hn2t0WYZ6UsFoC2q5BUxwfjWBEYI3i33k-17W36lXpc4I1j7XyJdV0MtmfBCSJkb9JG0hb6i6hqpdczewTbo2rHoW9ERfgLnBJFYHtmobS5IsRnQynyKtyjw3ag5qHC5xsmfqKZ1YcIYO5OPt-1u-Zv1khVbWvvLHTUNedtl1t~JVTa9pzVHSYu82qWwY-wmJwE0DdJ-UnC8Fd~cndNrdwgzSlyTrgiEJHIIjRjHFpj64wIHduPu1T0ANdiYOk3QCSrnZ0Y2s5qugiyuvKoG-eZ6Wtv1-UZ7NvmFeel1XtYuXkRd4c3Zee6CL-H88jFBc3DEFo9KWMOHyABBq4JXAA__",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(92.dp)
            )
            Text(
                text = "О магазинах Волгограда",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(listOf(Font(R.font.manrope_medium))),
                color = Color.White
            )
        }
        Box(
            modifier = Modifier
                .size(92.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            AsyncImage(
                model = "https://s3-alpha-sig.figma.com/img/3a2c/4461/0e8d8d0e36b5cfe59efca342e9a4f35d?Expires=1732492800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=oOs0VzvoOlT6Zu3sCvFgQEDV~QLQe0g9jqGrqMA9dHjHR5bq6WoTjYBIq3CQ8VcjPYGi9AiHna-7ulcLcBRUBxj7P5TFglSPgl23MFC99tuwEqArNh0kD01-jNXoCPIHiopdcskGJy~p3Tsu9vjzo2IWLhIJnUu4fjBFXq6E~VH20rPKI9AIOFBR8OG0p-tWohz6v1N2lT5U3pjTFySIBPrBxNXceRgnF3HtbkVlr981vTD5jPPXCGCJ4TVSrXF7KDH1SIl3UrXKbTO2YKC-Kydq20CnLaSVPax07wXbIId8KZ7RRN0gYuNAA8dRx1UHHNSEsxAf~rkyPgWTKR4cZw__",
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "Новые поступления",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(listOf(Font(R.font.manrope_medium))),
                color = Color.White
            )
        }
        Box(
            modifier = Modifier
                .size(92.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            AsyncImage(
                model = "https://s3-alpha-sig.figma.com/img/cfbb/41bd/10acc06b68fd0bf9cefbbe9d87dd8d7b?Expires=1732492800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=jO-YpqGjYqsgqkPN53kA6qje7-3NbKw65~uM5avo0ZBIDAMA8R9xMZ3p44vFCs34IG1krv8f5XF0~UEHequ~d6Am-ijC2lA9NxuLsNPoPJtzYgA5Y4rW7TpmGqOuEztwngM9cKIiwNmfsHWmZNoHNUipETkuIsYRRoQObJidRSQcY9WoRLGLOsA-VtivRUPWacjGXzadpmO82lPPvluodWdJOJFU89UiWO~9Luf~MQhRAw6kPRmDc1hp0SkmEdwtM40v0LZJGYlPIa6XP1jFxV-bhmNc7rs3-rqdw5xm0Wff51SY9inQm4IBHAQ3KEdbI0ySTcCP4vM4eu90kaKuBQ__",
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "Одежда бренда Christian Dior",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(listOf(Font(R.font.manrope_medium))),
                color = Color.White
            )
        }
        Box(
            modifier = Modifier
                .size(92.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            AsyncImage(
                model = "https://s3-alpha-sig.figma.com/img/159f/8d96/2114df75ea5c1e0a0b5b524d492cb623?Expires=1732492800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=pSK0EgbbbHsQl1u5egjXIOFC6dXI0kPuQ6WEsvPqFJRie0NUQrlPKRObn39OxLBrgBsqeaPlnPcL8d4I9UzImCrEsZtciaoPAPQ7Z~K9PxV3v-wiy4ax8vQdRxUjTkm16Nl0pfWr2obE-QRAgzA3DYpd0Q60sm6pWLxEFqzJTU0ps2AplWYboaaxWzNKwLNGy8vufxlFkM2iZHR7r-3BjypUHuqruoLCIVfm1XJF~WHN7d7IYTOQB5gxPd~~2rHzAKR3V-iyJQlI7Z7rJoVwVIltIUJFgRbCcsBi822q2lzV3ZI8j-jcK0~Yemivq-l~zMjTLpC-u2CsIesm9hgdxw__",
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "Купоны и скидки в приложении",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(listOf(Font(R.font.manrope_medium))),
                color = Color.White
            )
        }
    }
}

@Composable
fun LazyRowCodeCenterMain(
    onClick: () -> Unit,
    money: String,
    scores: String,
    cashBack: String,
    profile: String,
){
    Box(
        modifier = Modifier
            .padding(15.dp, 0.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(169.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF46423E).copy(0.1f),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.TopStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        modifier = Modifier
                            .padding(
                                top = 0.dp,
                                end = 0.dp,
                                start = 20.dp,
                                bottom = 0.dp
                            )
                            .width(212.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(7.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(7.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.surprisebox),
                                    contentDescription = null,
                                    tint = Color(0xFFE7D52F)
                                )
                                Text(
                                    text = money,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily(listOf(Font(R.font.manrope_bold))),
                                )
                            }
                            Text(
                                text = scores,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(color = Color(0xFF46423E).copy(0.1f))
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(50.dp)
                                ) {
                                    Text(
                                        text = cashBack,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily(listOf(Font(R.font.manrope_bold))),
                                    )
                                    Icon(
                                        modifier = Modifier
                                            .clickable { onClick() },
                                        imageVector = ImageVector.vectorResource(R.drawable.chevron_right1),
                                        contentDescription = null,
                                    )
                                }
                                Text(
                                    text = profile,
                                    fontSize = 14.sp,
                                    lineHeight = 19.2.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold))),
                                )
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .width(150.dp)
                            .height(169.dp)
                            .background(
                                color = Color(0xFFE7D52F),
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 8.dp,
                                    bottomStart = 0.dp,
                                    bottomEnd = 8.dp
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFE7D52F),
                                    shape = RoundedCornerShape(8.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(75.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                AsyncImage(
                                    model = "https://s3-alpha-sig.figma.com/img/2719/c139/e208c90fb342991b1adb967066c3c2bb?Expires=1732492800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=dCYtZrh95-053e5JRCDAiPnlXdUL559CFCDI8mJ6bNUSsTZO-RkS2VLkPkvf1FNq7hYDKG4M2KWPS9OYW4t-mLSWKiLllDj6pFZzh3Hhvn~yZyGx-~YFMU~8VUxBrGy5RTlgv-JtTUKFxgsIHDYfyV6GI5YoLQ3lZuZTS0WqQSXB8ehbEOplpkBxxdi0zW2Gb08Wl3hKK9dLfqx1sm-uQR6qPlbz0V7oHicDh7AXXTb7a~TC6t2ytffoS021mC-CRv289XHholRzrcL7FVS3ZhHV-FghXTcG73VgfBLe4F7cIc6OnKCTPIyl3fCIQHJQtRN6MESdXuLIOg4lqVf25g__",
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Image(
                                    modifier = Modifier
                                        .clickable { onClick() },
                                    imageVector = ImageVector.vectorResource(R.drawable.magnifier),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
            ButtonMain(
                onClick = {},
                service = "О сервисе",
                help = "Помощь"
            )
        }
    }
}

@Composable
fun ButtonMain(
    onClick: () -> Unit,
    service: String,
    help: String
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Box(
            modifier = Modifier
                .width(174.dp)
                .height(46.dp)
                .clickable { onClick() }
                .background(
                    color = Color(0xFF46423E),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(61.dp)
            ) {
                Text(
                    text = help,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold))),

                    )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.chevron_right1),
                    contentDescription = null
                )
            }
        }
        Box(
            modifier = Modifier
                .width(174.dp)
                .height(46.dp)
                .clickable { onClick() }
                .background(
                    color = Color(0xFF46423E),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(45.dp)
            ) {
                Text(
                    text = service,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold))),

                    )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.chevron_right1),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun CollectionCenterMain(
    nameCollection: String,
    womenClothing: String,
    boysClothing: String,
    childrenClothing: String,
    onClick: () -> Unit
){
    Box(
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = nameCollection,
                fontSize = 20.sp,
                fontFamily = FontFamily(listOf(Font(R.font.manrope_bold))),
                fontWeight = FontWeight.Bold
            )
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                item {

                }
            }
        }
    }
}



@Preview
@Composable
fun CenterMainPreview(){
    Surface {
        CenterMain(
            onClick = {}
        )
    }
}