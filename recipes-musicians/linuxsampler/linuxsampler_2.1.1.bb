SUMMARY = "LinuxSampler - modular, streaming capable sampler"
HOMEPAGE = "http://www.linuxsampler.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=0640e0c29fde7334746a009461544030 \
"
# See Homepafe
LICENSE_FLAGS = "commercial"

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
    file://0005-Adjust-libdir.patch \
"
SRC_URI[md5sum] = "8fda14da0ccfc141d5af08daedccaae6"
SRC_URI[sha256sum] = "20050b22066e9cdbdad34c0470d3c4a47f75e4af620fd98af277f5d2417132be"

# arch specific override - default (tested) is ARM -> no assember (ARM assembler is not suppoted)
USE_ASM = "--disable-asm"

EXTRA_OECONF = " \
    ${USE_ASM} \
    --enable-unsigned-triang-algo=intmathabs \
    --enable-signed-triang-algo=intmathabs \
    --enable-plugin-dir=${libdir}/${BPN}/plugins \
"

CXXFLAGS += "-std=c++11"

do_install:append() {
    mv ${D}${libdir}/${BPN}/* ${D}${libdir}
    rmdir ${D}${libdir}/${BPN}

    rmdir ${D}${libdir}/plugins
    install -Dd ${D}${libdir}/${BPN}/plugins
}

PACKAGES =+ "${PN}-standalone ${PN}-tools"
FILES:${PN}-standalone = " \
    ${bindir}/${BPN} \
"

FILES:${PN}-tools = " \
    ${bindir}/lscp \
    ${bindir}/ls_instr_script \
"

RDEPENDS:${PN_DSSI} += "${PN}"
RDEPENDS:${PN_LV2} += "${PN}"
RDEPENDS:${PN_VST} += "${PN}"
RDEPENDS:${PN}-standalone += "${PN}"

