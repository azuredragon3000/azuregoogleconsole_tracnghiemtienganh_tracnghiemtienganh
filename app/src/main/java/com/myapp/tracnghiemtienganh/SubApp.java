/*
 * Copyright 2020 Google LLC. All rights reserved.
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

package com.myapp.tracnghiemtienganh;

import android.app.Application;

import java.util.ArrayList;


/**
 * Android Application class. Used for accessing singletons.
 */
public class SubApp extends Application {
    ArrayList<String> ques = new ArrayList<>();
    public void InitQuestion(){
        for (int i = 0; i < 1000; i++) {
            ques.add("Câu hỏi: " + i);
        }
    }
    public ArrayList<String> getQuestion(){
        return ques;
    }
    public void updateQuestion(int index){
        ques.remove(index);
    }
    public DatabasePhatGiao getDatabasePhatGiao() {
        return DatabasePhatGiao.getInstance(this);
    }
}
