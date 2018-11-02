/*
 * Copyright (c) 2011-2018 Nexmo Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.nexmo.client.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexmo.client.NexmoUnexpectedException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PricingResponse {
    private String dialingPrefix;
    private BigDecimal defaultPrice;
    private String currency;
    @JsonUnwrapped
    private Country country;
    private List<Network> networks;

    public String getDialingPrefix() {
        return dialingPrefix;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public Country getCountry() {
        return country;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public static PricingResponse fromJson(String json) {
        try {
            return new ObjectMapper().readValue(json, PricingResponse.class);
        } catch (IOException jpe) {
            throw new NexmoUnexpectedException("Failed to produce PricingResponse from json.", jpe);
        }
    }
}