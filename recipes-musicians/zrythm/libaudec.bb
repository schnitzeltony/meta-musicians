SUMMARY = "A library for reading and resampling audio files"
HOMEPAGE = "https://www.zrythm.org/"
LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb1e647870add0502f8f010b19de32af"

inherit meson

SRC_URI = "git://github.com/zrythm/libaudec.git"
SRCREV = "734b30dbb15fa780b06a5cf261f9b29484ef8cfa"
PV = "0.2"
S = "${WORKDIR}/git"


DEPENDS = " \
    libsndfile1 \
    libsamplerate0 \
"

PACKAGECONFIG ??= "ffmpeg"
PACKAGECONFIG[ffmpeg] = "-Denable_ffmpeg=true,-Denable_ffmpeg=false,ffmpeg"
