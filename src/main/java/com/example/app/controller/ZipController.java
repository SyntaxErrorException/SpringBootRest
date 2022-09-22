package com.example.app.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Zip;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ZipController {
	// /zip?code=1700001のようなURLを想定する
	@GetMapping("/zip")
	public String search(@RequestParam(name="code", required=false) String code, Model model) throws IOException, InterruptedException  {
		if (code != null) {
			//住所を検索する
			//エンドポイントを作る
			String url = "https://zipcloud.ibsnet.co.jp/api/search";
			//パラメータを準備する
			url += "?zipcode=" + code;
			//リクエストの準備をする
			HttpClient client = HttpClient.newBuilder().build();
			HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
			//リクエストの送信と結果の取得
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			System.out.println(response.body());
			//JSON→Zipオブジェクトに変換する
			ObjectMapper mapper = new ObjectMapper();
			Zip zip = mapper.readValue(response.body(), Zip.class);
			model.addAttribute("zip", zip);
		}
		return "zip";
	}
}
