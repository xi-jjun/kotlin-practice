package me.practice.kotlinspring.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureRestDocs
@WebMvcTest(GetApiController::class)
internal class GetApiControllerTest(@Autowired var mockMvc: MockMvc) {

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
        mockMvc.perform(
            RestDocumentationRequestBuilders.get("/api/greeting/{userName}", "xi-jjun")
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(
                document(
                    // build/generated-snippets/get-practice/hello-api/ 에 docs 가 만들어진다.
                    "get-practice/hello-api",
                    pathParameters(
                        // path parameter 인 'userName'에 대한 설명을 명시하는 코드
                        parameterWithName("userName").description("user name")
                    ), responseFields(
                        // response json data 에서 'greeting' field 에 대한 설명을 명시하는 코드
                        fieldWithPath("greeting").description("greeting text for user")
                    )
                )
            )
    }

    @DisplayName("GET-/api/query-param?name={name}&age={age}&address={address} 요청에 대해 userRequest 객체를 반환해야 함")
    @Test
    fun `query parameter by url test`() {
        mockMvc.perform(
            RestDocumentationRequestBuilders.get("/api/query-param")
                .param("name", "xi-jjun")
                .param("age", "26")
                .param("address", "Seoul")
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(
                document(
                    "get-practice/query-param-1",
                    pathParameters(
                        // 지금 요청은 path parameter 가 아니라 query parameter 로 날리기 때문에 당연하게 없어야 한다.
//                        parameterWithName("name").description("user name"),
//                        parameterWithName("age").description("user age"),
//                        parameterWithName("address").description("user address")
                    ), responseFields(
                        fieldWithPath("name").description("user response name"),
                        fieldWithPath("age").description("user response age"),
                        fieldWithPath("address").description("user response address"),
                    )
                )
            )
    }

    @DisplayName("GET-/api/query-param-dto?name={name}&age={age}&address={address} 요청에 대해 userRequest 객체를 반환해야 함")
    @Test
    fun `query parameter by request dto test`() {
        mockMvc.perform(
            RestDocumentationRequestBuilders.get("/api/query-param-dto")
                .param("name", "xi-jjun")
                .param("age", "26")
                .param("address", "Busan")
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(
                document(
                    "get-practice/query-param-dto",
                    pathParameters(
                        // 지금 요청은 path parameter 가 아니라 query parameter 로 날리기 때문에 당연하게 없어야 한다.
//                        parameterWithName("name").description("user name"),
//                        parameterWithName("age").description("user age"),
//                        parameterWithName("address").description("user address")
                    ), responseFields(
                        fieldWithPath("name").description("user response name"),
                        fieldWithPath("age").description("user response age"),
                        fieldWithPath("address").description("user response address"),
                    )
                )
            )
    }

    @DisplayName("GET-/api/query-param-map?anyInt={anyInt}&anyString={anyString}&any={any} 요청에 대해서 json object 반환")
    @Test
    fun `query parameter by map test`() {
        mockMvc.perform(
            RestDocumentationRequestBuilders.get("/api/query-param-map")
                .param("anyInt", "123")
                .param("anyString", "Hello Rest Docs!!")
                .param("any", "A N Y")
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(
                document(
                    "get-practice/query-param-map",
                    responseFields(
                        fieldWithPath("anyInt").description("any integer number"),
                        fieldWithPath("anyString").description("any string value"),
                        fieldWithPath("any").description("any value")
                    )
                )
            )
    }
}