<br><br>
### 🦁 멋사 6주차 과제 🦁

| 실습 <br> 6 | 캡쳐 | 
|:------:|:------|
|`Model`| <img width="782" src="https://github.com/Likelion-at-SMWU-12th/LeeHyoRim/assets/127765134/43ea0127-c049-4060-a413-ce315195efad"> <br>Model은 데이터 모델을 의미하며, 장고의 model 모듈을 이용하여 DB의 테이블과 일치하는 데이터 구조를 정의한다. <br> 과제로 Comment모델을 만들었으며 작성자 이름, 내용, 좋아요 수, 싫어요 수가 요소로 포함 됨.|
|`View`| View는 http request를 받아 결과인 response를 리턴한다. Model을 통해 필요한 데이터에 접근해 Template에게 응답으로 보여줄 데이터를 제공해주는 역할을 한다. 데이터를 가공하는 로직은 views.py 파일에서 코드를 작성해 처리한다.|
|`Template`|  <img width="782" src="https://github.com/Likelion-at-SMWU-12th/LeeHyoRim/assets/127765134/3ad4688e-cb3c-4acc-b07b-f1f6bbc72719"> <br>Template은 사용자에게 보여지는 html과 같은 페이지이다. View로부터 전달된 데이터를 템플릿에 적용하여 동적 웹 페이지 만드는데 사용된다. |

### 🦁 멋사 12주차 과제 🦁
#### Java 어노테이션
1. @Override
용도: 부모 클래스의 메서드를 재정의할 때 사용.
예시:
java
코드 복사
@Override
public String toString() {
    return "Example";
}
2. @Deprecated
용도: 더 이상 사용되지 않는 코드를 표시하고 대체 방법을 권장.
예시:
java
코드 복사
@Deprecated
public void oldMethod() {
    // ...
}
3. @SuppressWarnings
용도: 컴파일러가 특정 경고를 무시하도록 지시.
예시:
java
코드 복사
@SuppressWarnings("unchecked")
public void someMethod() {
    // ...
}
Spring 프레임워크 어노테이션
1. @RestController
용도: 해당 클래스가 RESTful 웹 서비스의 컨트롤러임을 명시.
예시:
java
코드 복사
@RestController
public class MyController {
    // ...
}
2. @RequestMapping
용도: 특정 URL 패턴과 HTTP 메서드에 매핑되는 요청을 처리.
예시:
java
코드 복사
@RequestMapping(value = "/api/resource", method = RequestMethod.GET)
public ResponseEntity<String> getResource() {
    return new ResponseEntity<>("Resource", HttpStatus.OK);
}
3. @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
용도: HTTP GET, POST, PUT, DELETE 요청을 처리하는 메서드에 대한 매핑.
예시:
java
코드 복사
@GetMapping("/api/resource")
public ResponseEntity<String> getResource() {
    return new ResponseEntity<>("Resource", HttpStatus.OK);
}

@PostMapping("/api/resource")
public ResponseEntity<String> createResource(@RequestBody String resource) {
    return new ResponseEntity<>("Created", HttpStatus.CREATED);
}
4. @PathVariable
용도: URL 경로에서 변수를 추출하여 메서드 파라미터에 바인딩.
예시:
java
코드 복사
@GetMapping("/api/resource/{id}")
public ResponseEntity<String> getResourceById(@PathVariable("id") String id) {
    return new ResponseEntity<>(id, HttpStatus.OK);
}
5. @RequestParam
용도: HTTP 요청의 쿼리 파라미터를 메서드 파라미터에 바인딩.
예시:
java
코드 복사
@GetMapping("/api/resource")
public ResponseEntity<String> getResourceByParam(@RequestParam("name") String name) {
    return new ResponseEntity<>(name, HttpStatus.OK);
}
6. @RequestBody
용도: HTTP 요청 본문을 메서드 파라미터에 바인딩.
예시:
java
코드 복사
@PostMapping("/api/resource")
public ResponseEntity<String> createResource(@RequestBody String resource) {
    return new ResponseEntity<>("Created", HttpStatus.CREATED);
}
7. @ResponseBody
용도: 메서드의 반환 값을 HTTP 응답 본문으로 직렬화.
예시:
java
코드 복사
@GetMapping("/api/resource")
@ResponseBody
public String getResource() {
    return "Resource";
}
8. @Autowired
용도: 스프링의 의존성 주입을 위해 사용.
예시:
java
코드 복사
@Service
public class MyService {
    @Autowired
    private MyRepository myRepository;
}
기타 어노테이션
1. @Component, @Service, @Repository, @Controller
용도: 스프링의 컴포넌트 스캔을 통해 자동으로 빈으로 등록.
예시:
java
코드 복사
@Component
public class MyComponent {
    // ...
}

@Service
public class MyService {
    // ...
}

@Repository
public class MyRepository {
    // ...
}

@Controller
public class MyController {
    // ...
}
이와 같은 어노테이션들은 API 개발 과정에서 코드의 가독성과 유지 보수성을 높이고, 개발자가 비즈니스 로직에 집중할 수 있도록 돕습니다. 각각의 어노테이션은 특정한 기능과 목적을 가지고 있으며, 이를 적절히 사용함으로써 효율적인 API 개발이 가능합니다.
