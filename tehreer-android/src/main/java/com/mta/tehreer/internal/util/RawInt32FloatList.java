/*
 * Copyright (C) 2017 Muhammad Tayyab Akram
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mta.tehreer.internal.util;

import com.mta.tehreer.internal.Raw;
import com.mta.tehreer.util.FloatList;

public class RawInt32FloatList extends FloatList {

    private final long pointer;
    private final int size;

    public RawInt32FloatList(long pointer, int size) {
        this.pointer = pointer;
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public float get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return Raw.getInt32Value(pointer, index);
    }

    @Override
    public void set(int index, float value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float[] toArray(float scale) {
        return Raw.arrayForInt32Floats(pointer, size, scale);
    }
}
