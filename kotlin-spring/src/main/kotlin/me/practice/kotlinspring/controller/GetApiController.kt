package me.practice.kotlinspring.controller

import me.practice.kotlinspring.controller.dto.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello Kotlin!!"
    }

    @GetMapping("/greeting/{userName}")
    fun greetingUser(@PathVariable("userName") _userName: String): String {
        val userName = _userName
        return "Hello, $userName!"
    }

    @GetMapping("/query-param")
    fun queryParam(
        @RequestParam(value = "user") user: String,
        @RequestParam(value = "age") age: Int,
        @RequestParam(name = "nickname") nickname: String
    ): String {
        return "$user info : {\n" +
                "\tuser name : $user\n" +
                "\tuser age : $age\n" +
                "\tuser nickname : $nickname\n}"
    }

    /**
     * query parameter 로 들어온 user, age, address 를 dto 로 받는 controller method
     * @param userRequest 사용자 요청 정보 dto
     *
     * @RestController 를 쓰면 object 의 경우는 자동으로 json format 으로 변형되어 반환이 된다.
     */
    @GetMapping("/query-param-dto")
    fun getUser(userRequest: UserRequest): UserRequest {
        return userRequest
    }

    /*
    query parameter 로 뭐가 들어올지 알 수 없을 때 사용하면 좋다.
    주의 : @RequestParam 붙여줘야 한다.
     */
    @GetMapping("/query-param-map")
    fun getMapUser(@RequestParam map: Map<String, Any>): Map<String, Any> {
        return map
    }
}