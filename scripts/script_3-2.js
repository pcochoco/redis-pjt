import http from 'k6/http';
import {check} from 'k6';
import {randomItem} from 'https://jslib.k6.io/k6-utils/1.2.0/index.js';

export const options = {
  // 가상 유저(VUs) 100명으로 설정
  vus: 100,

  // 테스트를 10초 동안 진행
  duration: '10s',
};

// 검색어 리스트 정의
const keywords = [
  'spring', 'java', 'redis', 'mysql', 'jpa',
  'k6', 'performance', 'test', 'load', 'stress',
  'docker', 'kubernetes', 'aws', 'cloud', 'microservices',
  'python', 'javascript', 'react', 'vue', 'angular'
];

export default function () {
  // 1. 검색 API 호출
  // 랜덤한 키워드 선택
  const keyword = randomItem(keywords);
  
  // 검색 요청
  const searchRes = http.get(`http://localhost:8080/search/redis?keyword=${keyword}`);
  
  check(searchRes, {
    'search status is 200': (r) => r.status === 200,
  });

  // 2. 인기 검색어 조회 API 호출
  const top10Res = http.get('http://localhost:8080/search/top10/redis');
  
  check(top10Res, {
    'top10 status is 200': (r) => r.status === 200,
  });
}
