import http from 'k6/http';
import { check, sleep } from 'k6';
import { randomIntBetween } from 'https://jslib.k6.io/k6-utils/1.2.0/index.js';

export const options = {
  // 가상 유저(VUs) 1000명으로 설정
  vus: 1000,

  // 테스트를 10초 동안 진행
  duration: '10s',
};

export default function () {
  // 랜덤 데이터 생성
  // 유저는 1~10,000명, 게시글은 1~100개라고 가정
  const userId = randomIntBetween(1, 10000);
  const postId = randomIntBetween(1, 100);

  // 좋아요 API
  const url = 'http://localhost:8080/likes';
  const payload = JSON.stringify({
    userId: userId,
    postId: postId,
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  // POST 요청 전송
  const res = http.post(url, payload, params);

  // 응답 상태 코드 확인 (200 OK가 왔는 지 체크)
  check(res, {
    'status is 200': (r) => r.status === 200,
  });
}