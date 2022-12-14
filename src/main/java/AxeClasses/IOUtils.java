package AxeClasses;
// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.


import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.Closeables;

public class IOUtils {
    private static final int BUFFER = 4096;

    public static String readFully(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[BUFFER];
        int length;
        while ((length = in.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, length, "UTF-8"));
        }

        in.close();

        return sb.toString();
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            Closeables.close(closeable, true);
        } catch (IOException ignoted) {
        }
    }
}