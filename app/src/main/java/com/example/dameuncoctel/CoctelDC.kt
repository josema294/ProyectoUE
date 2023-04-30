package com.example.dameuncoctel

import android.os.Parcel
import android.os.Parcelable

data class CoctelDC(var id: Int,
                    val nombre: String,
                    val foto: Int,
                    val categoria:String,
                    val tipoVaso:String,
                    val ingredientes:List<String>,
                    val instrucciones:String,
                    val medidas:List<String>,
                    val tags:List<String>,

                    )
