/**
 * Copyright Pravega Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.pravega.storage.s3;

import io.pravega.segmentstore.storage.SegmentHandle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class S3SegmentHandle implements SegmentHandle {
    private final String segmentName;
    private final boolean isReadOnly;


    @Override
    public String getSegmentName() {
        return segmentName;
    }

    @Override
    public boolean isReadOnly() {
        return isReadOnly;
    }

    public static S3SegmentHandle getReadHandle(String streamSegmentName) {
        return new S3SegmentHandle(streamSegmentName, true);
    }

    public static S3SegmentHandle getWriteHandle(String streamSegmentName) {
        return new S3SegmentHandle(streamSegmentName, false);
    }
}
