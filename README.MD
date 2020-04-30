#springboot-dynamic

测试背景：
模拟mysql主从复制，一主二从
├── master
│   ├── dynamic_apple
│   │   └── apple
│   └── dynamic_peach
│       └── peach
├── slave1
│   ├── dynamic_apple
│   │   └── apple
│   └── dynamic_peach
└── slave2
    ├── dynamic_apple
    │   └── apple
    └── dynamic_peach
        └── peach

测试用例：
1.读写分离：
    数据操作master，只能操作slave1 salve2。
2.读取数据分库：
    读取apple表时，轮询从slave1下的dynamic_apple和slave2下的dynamic_apple库中读取。
    读取peach表时，轮询从slave1下的dynamic_peach和slave2下的dynamic_peach库中读取。
    
