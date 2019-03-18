SUMMARY = "LinuxSampler - modular, streaming capable sampler"
HOMEPAGE = "http://www.linuxsampler.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=0640e0c29fde7334746a009461544030 \
"

inherit autotools pkgconfig pack_audio_plugins

DEPENDS = " \
    bison-native \
    bison \
    libgig \
    jack \
    dssi \
    lv2 \
"

SRC_URI = " \
    http://download.linuxsampler.org/packages/${BPN}-${PV}.tar.bz2 \
    file://0001-configure.ac-Do-not-try-to-run-code-to-check-for-UNI.patch \
    file://0002-RTMath.cpp-use-clock_gettime-when-configured-with-di.patch \
    file://0003-Use-correct-call-of-snd_pcm_hw_params_set_rate_near.patch \
    file://0004-use-c-11-atomics-when-configured-with-disable-asm.patch \
"
SRC_URI[md5sum] = "c57fbd1310e9189ee72acf81e63bf3d5"
SRC_URI[sha256sum] = "4e0a49efeae9c26a223094247b7e01108d829a69618492282a203a290fbfbd39"

# arch specific override - default (tested) is ARM -> no assember (ARM assembler is not suppoted)
USE_ASM = "--disable-asm"

EXTRA_OECONF = " \
    ${USE_ASM} \
    --enable-unsigned-triang-algo=intmathabs \
    --enable-signed-triang-algo=intmathabs \
"

FILES_SOLIBSDEV = "${libdir}/${BPN}/lib*${SOLIBSDEV}"

PACKAGES =+ "${PN}-standalone ${PN}-tools"
FILES_${PN}-standalone = " \
    ${bindir}/${BPN} \
"

FILES_${PN}-tools = " \
    ${bindir}/lscp \
    ${bindir}/ls_instr_script \
"

RDEPENDS_${PN}-dssi += "${PN}"
RDEPENDS_${PN}-lv2 += "${PN}"
RDEPENDS_${PN}-vst += "${PN}"
RDEPENDS_${PN}-standalone += "${PN}"

