/*
 * Copyright 2021 Appmattus Limited
 * Copyright 2019 Babylon Partners Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * File modified by Appmattus Limited
 * See: https://github.com/appmattus/certificatetransparency/compare/e3d469df9be35bcbf0f564d32ca74af4e5ca4ae5...main
 */

package com.babylon.certificatetransparency.sampleapp.item.button

import android.view.View
import androidx.annotation.StringRes
import com.babylon.certificatetransparency.sampleapp.R
import com.babylon.certificatetransparency.sampleapp.databinding.ButtonItemBinding
import com.babylon.certificatetransparency.sampleapp.item.ItemCallback
import com.xwray.groupie.viewbinding.BindableItem

class ButtonItem(
    @StringRes private val titleResId: Int? = null,
    private val title: String? = null,
    private val callback: ItemCallback<ButtonItem>? = null
) : BindableItem<ButtonItemBinding>() {

    init {
        check((titleResId != null) xor (title != null)) { "Provide either titleResId or title" }
    }

    override fun initializeViewBinding(view: View) = ButtonItemBinding.bind(view)

    override fun getLayout() = R.layout.button_item

    override fun bind(viewBinding: ButtonItemBinding, position: Int) {
        val context = viewBinding.root.context
        viewBinding.button.apply {
            text = if (titleResId != null) context.getString(titleResId) else title

            setOnClickListener {
                callback?.invoke(this@ButtonItem)
            }
        }
    }
}
