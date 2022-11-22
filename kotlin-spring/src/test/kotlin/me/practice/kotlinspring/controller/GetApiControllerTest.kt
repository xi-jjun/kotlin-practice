package me.practice.kotlinspring.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
internal class GetApiControllerTest(@Autowired val mockMvc: MockMvc) {

    @DisplayName("GET-/api/hello 요청에 대해 'Hello Kotlin!!'을 반환해야 함")
    @Test
    fun `hello kotlin test`() {
        mockMvc.perform(get("/api/hello"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
            .andExpect(content().string("Hello Kotlin!!"))
    }

    @DisplayName("GET-/api/greeting/{user name} 요청에 대해 'Hello, {user name}!'을 반환해야 함")
    @Test
    fun `greeting to user test`() {
        mockMvc.perform(get("/api/greeting/xi-jjun"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
            .andExpect(content().string("Hello, xi-jjun!"))
    }
}