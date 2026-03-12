import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  // 가상 유저(VUs) 100명으로 설정
  vus: 100,

  // 테스트를 10초 동안 진행
  duration: '10s',
};

export default function () {
  // 재고 차감 API
  const url = 'http://localhost:8080/stocks/1/decrease/redis';

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  // POST 요청 전송
  const res = http.post(url, null, params);

  // 1초 간격으로 요청 발송
  sleep(1);

  // 응답 상태 코드 확인 (200 OK가 왔는 지 체크)
  check(res, {
    'status is 200': (r) => r.status === 200,
  });
}