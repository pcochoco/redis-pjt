import http from 'k6/http';
import {check} from 'k6';

export const options = {
  vus: 1000,
  duration: '10s',
};

export default function () {
  // 1. 유저 활동 기록
  const userId = Math.floor(Math.random() * 100000) + 1; // 1 ~ 100000 사이의 랜덤 userId
  const payload = JSON.stringify({
    userId: userId,
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const recordRes = http.post('http://localhost:8080/dau/record/redis', payload, params);

  check(recordRes, {
    'record status is 200': (r) => r.status === 200,
  });

  // 2. DAU 조회
  // 오늘 날짜를 YYYY-MM-DD 형식으로 가져온다.
  const today = new Date().toISOString().split('T')[0];
  const countRes = http.get(`http://localhost:8080/dau/count/redis?date=${today}`);

  check(countRes, {
    'count status is 200': (r) => r.status === 200,
  });
}
