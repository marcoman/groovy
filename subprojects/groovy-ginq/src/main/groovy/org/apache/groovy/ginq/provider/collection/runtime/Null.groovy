/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.groovy.ginq.provider.collection.runtime

import groovy.transform.PackageScope

/**
 * Represents null object for GINQ
 *
 * @since 4.0.0
 */
@PackageScope
class Null {
    public static final Null INSTANCE = new Null()

    private Null() {}

    def methodMissing(String name, def args) {
        return null
    }

    def propertyMissing(String name) {
        return null
    }

    def propertyMissing(String name, def value) {
        return null
    }

    static $static_methodMissing(String name, def args) {
        return null
    }

    static $static_propertyMissing(String name) {
        return null
    }

    boolean asBoolean() {
        return false
    }

    def asType(Class c) {
        return this
    }

    boolean is(Object other) {
        return other === this
    }

    @Override
    int hashCode() {
        return 0
    }

    @Override
    boolean equals(Object obj) {
        return obj === this
    }

    @Override
    Object clone() {
        return this
    }
}