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
package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.GroovyCodeVisitor;

/**
 * Represents a spread map expression *:m
 * in the map expression [1, *:m, 2, "c":100]
 * or in the method invoke expression func(1, *:m, 2, "c":100).
 */
public class SpreadMapExpression extends Expression {

    private final Expression expression;

    public SpreadMapExpression(final Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String getText() {
        return "*:" + getExpression().getText();
    }

    @Override
    public ClassNode getType() {
        return getExpression().getType();
    }

    @Override
    public Expression transformExpression(final ExpressionTransformer transformer) {
        Expression ret = new SpreadMapExpression(transformer.transform(getExpression()));
        ret.setSourcePosition(this);
        ret.copyNodeMetaData(this);
        return ret;
    }

    @Override
    public void visit(final GroovyCodeVisitor visitor) {
        visitor.visitSpreadMapExpression(this);
    }
}
