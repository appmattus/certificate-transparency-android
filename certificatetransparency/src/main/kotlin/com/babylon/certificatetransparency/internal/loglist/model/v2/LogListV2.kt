/*
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
 */

package com.babylon.certificatetransparency.internal.loglist.model.v2

import com.google.gson.annotations.SerializedName

/**
 * @property version Version of this log list. The version will change whenever a change is made to any part of this log list.
 * @property operators CT log operators. People/organizations that run Certificate Transparency logs.
 */
internal data class LogListV2(
    @SerializedName("version") val version: String?,
    @SerializedName("operators") val operators: List<Operator>
)
