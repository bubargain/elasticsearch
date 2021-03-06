/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.test.unit.action.search;

import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.io.Streams;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

/**
 */
@Test
public class MultiSearchRequestTests {

    @Test
    public void simpleAdd() throws Exception {
        byte[] data = Streams.copyToBytesFromClasspath("/org/elasticsearch/test/unit/action/search/simple-msearch1.json");
        MultiSearchRequest request = new MultiSearchRequest().add(data, 0, data.length, false, null, null, null);
        assertThat(request.getRequests().size(), equalTo(5));
        assertThat(request.getRequests().get(0).getIndices()[0], equalTo("test"));
        assertThat(request.getRequests().get(0).getTypes().length, equalTo(0));
        assertThat(request.getRequests().get(1).getIndices()[0], equalTo("test"));
        assertThat(request.getRequests().get(1).getTypes()[0], equalTo("type1"));
        assertThat(request.getRequests().get(2).getIndices(), nullValue());
        assertThat(request.getRequests().get(2).getTypes().length, equalTo(0));
        assertThat(request.getRequests().get(3).getIndices(), nullValue());
        assertThat(request.getRequests().get(3).getTypes().length, equalTo(0));
        assertThat(request.getRequests().get(3).getSearchType(), equalTo(SearchType.COUNT));
        assertThat(request.getRequests().get(4).getIndices(), nullValue());
        assertThat(request.getRequests().get(4).getTypes().length, equalTo(0));
    }

    @Test
    public void simpleAdd2() throws Exception {
        byte[] data = Streams.copyToBytesFromClasspath("/org/elasticsearch/test/unit/action/search/simple-msearch2.json");
        MultiSearchRequest request = new MultiSearchRequest().add(data, 0, data.length, false, null, null, null);
        assertThat(request.getRequests().size(), equalTo(5));
        assertThat(request.getRequests().get(0).getIndices()[0], equalTo("test"));
        assertThat(request.getRequests().get(0).getTypes().length, equalTo(0));
        assertThat(request.getRequests().get(1).getIndices()[0], equalTo("test"));
        assertThat(request.getRequests().get(1).getTypes()[0], equalTo("type1"));
        assertThat(request.getRequests().get(2).getIndices(), nullValue());
        assertThat(request.getRequests().get(2).getTypes().length, equalTo(0));
        assertThat(request.getRequests().get(3).getIndices(), nullValue());
        assertThat(request.getRequests().get(3).getTypes().length, equalTo(0));
        assertThat(request.getRequests().get(3).getSearchType(), equalTo(SearchType.COUNT));
        assertThat(request.getRequests().get(4).getIndices(), nullValue());
        assertThat(request.getRequests().get(4).getTypes().length, equalTo(0));
    }
    
    @Test
    public void simpleAdd3() throws Exception {
        byte[] data = Streams.copyToBytesFromClasspath("/org/elasticsearch/test/unit/action/search/simple-msearch3.json");
        MultiSearchRequest request = new MultiSearchRequest().add(data, 0, data.length, false, null, null, null);
        assertThat(request.getRequests().size(), equalTo(4));
        assertThat(request.getRequests().get(0).getIndices()[0], equalTo("test0"));
        assertThat(request.getRequests().get(0).getIndices()[1], equalTo("test1"));
        assertThat(request.getRequests().get(1).getIndices()[0], equalTo("test2"));
        assertThat(request.getRequests().get(1).getIndices()[1], equalTo("test3"));
        assertThat(request.getRequests().get(1).getTypes()[0], equalTo("type1"));
        assertThat(request.getRequests().get(2).getIndices()[0], equalTo("test4"));
        assertThat(request.getRequests().get(2).getIndices()[1], equalTo("test1"));
        assertThat(request.getRequests().get(2).getTypes()[0], equalTo("type2"));
        assertThat(request.getRequests().get(2).getTypes()[1], equalTo("type1"));
        assertThat(request.getRequests().get(3).getIndices(), nullValue());
        assertThat(request.getRequests().get(3).getTypes().length, equalTo(0));
        assertThat(request.getRequests().get(3).getSearchType(), equalTo(SearchType.COUNT));
    }
}
