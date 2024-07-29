let tjz = '{\'pzlx\':\'01\',\'sljg\':\'01000003\',\'ywlsh\':\'TJFA0000995401\',\'kjnd\':\'2023\',\'dzpzzt\':\'0\',\'showtype\':\'1\',\'userid\':\'1000000000000067122\',\'sfgx\':\'1\',\'hszt\':\'01010000\',\'ztbh\':\'{\'key\':\'01\',\'label\':\'住房公积金账套\'}\',\'gnbh\':\'pzgl\',\'famc\':\'查询方案2023\',\'hsztmc\':\'核算中心\'}'
let tjz1 = '{\'pzlx\':\'01\',\'sljg\':\'01000003\',\'ywlsh\':\'TJFA0000995401\',\'kjnd\':\'2023\',\'dzpzzt\':\'0\',\'showtype\':\'1\',\'userid\':\'1000000000000067122\',\'sfgx\':\'1\',\'hszt\':\'01010000\',\'gnbh\':\'pzgl\',\'famc\':\'查询方案2023\',\'hsztmc\':\'核算中心\'}'

console.log(tjz.lastIndexOf('\'{'))
tjz = tjz.replace('\'{', '{').replace('}\'', '}')

let result = eval('(' + (tjz) + ')');
// let result = JSON.parse(tjz);//SyntaxError: Unexpected token ' in JSON at position 1

console.log(result);
