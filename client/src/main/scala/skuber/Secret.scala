package skuber

import java.io._
import org.apache.commons.io.IOUtils

/**
 * @author David O'Riordan
 */
case class Secret(
    val kind: String ="Secret",
    override val apiVersion: String = v1,
    val metadata: ObjectMeta,
    data: Map[String, Array[Byte]] = Map())
  extends ObjectResource  {
  
    def add(key: String, is: InputStream) : Unit = {
       val bytes = IOUtils.toByteArray(is)
       add(key, bytes) 
    }
    def add(key: String, bytes: Array[Byte]) : Unit =
      this.copy(data = data + (key -> bytes))
} 

